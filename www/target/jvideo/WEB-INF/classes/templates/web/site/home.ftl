<#-- @ftlvariable name="properties" type="java.util.Map<java.lang.String,java.lang.Object>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../includes/meta.ftl">
    <title>api.video</title>
</head>

<body>
<div class="container">
    <form action="/api/videos/uploader" method="get">
        <ul>
            <li>
                <label for="apiKey">API Key:</label>
                <input type="text" id="apiKey" name="api_key">
            </li>
            <li>
                <label for="mail">Customer E-mail:</label>
                <input type="email" id="mail" name="customer_email">
            </li>
            <li class="button">
                <button type="submit">Submit</button>
            </li>
        </ul>
    </form>
</div>

<#include "../includes/scripts.ftl">
<script type="application/javascript">
    $(document).ready(function () {

        $(".see-more").click(function () {
            $.ajax("/partials/homestudies", {
                dataType: "html",
                type: 'GET',
                success: function (data) {
                    $('.studies').html(data);
                }
            });
        });
    });
</script>
</body>
</html>