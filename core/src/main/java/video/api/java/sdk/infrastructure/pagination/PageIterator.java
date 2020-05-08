package video.api.java.sdk.infrastructure.pagination;

import video.api.java.sdk.domain.exception.ResponseException;
import video.api.java.sdk.domain.pagination.Page;
import video.api.java.sdk.domain.pagination.PageQuery;

public class PageIterator<T> implements java.util.Iterator<T> {

    private final PageLoader<T>         pageLoader;
    private       java.util.Iterator<T> current;
    private       int                   pagesTotal;
    private       PageQuery             pageQuery;

    public PageIterator(PageLoader<T> pageLoader, PageQuery pageQuery) throws ResponseException, IllegalArgumentException {
        this.pageLoader = pageLoader;
        this.pageQuery  = pageQuery;
        this.current    = this.loadPage();
    }

    @Override
    public boolean hasNext() {

        if (this.current.hasNext()) {

            return true;
        } else {
            if (this.getCurrentPage() < pagesTotal) {
                this.incrementNumberPage();
                try {
                    this.current = this.loadPage();
                } catch (ResponseException | IllegalArgumentException e) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public T next() {
        return this.current.next();
    }

    private java.util.Iterator<T> loadPage() throws ResponseException, IllegalArgumentException {
        Page<T> page = pageLoader.load(pageQuery);

        pagesTotal = page.total;

        return page.items.iterator();
    }


    private void incrementNumberPage() {
        pageQuery.currentPage++;
    }

    private int getCurrentPage() {
        return pageQuery.currentPage;
    }


}