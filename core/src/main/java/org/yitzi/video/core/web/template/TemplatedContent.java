package org.yitzi.video.core.web.template;

import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplatedContent {

    private static final int BUFFER_SIZE = 1024 * 16;

    private String file;

    private Map<String, Object> properties = new HashMap<>();

    public TemplatedContent(String file) {
        this.file = file;
    }

    public String render() {
        try {
            StringWriter out = new StringWriter(BUFFER_SIZE);
            Template template = Templates.get().getConfiguration().getTemplate(file);
            template.process(this, out);
            return out.toString();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }
}
