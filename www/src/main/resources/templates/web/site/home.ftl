<#-- @ftlvariable name="properties" type="java.util.Map<java.lang.String,java.lang.Object>" -->
<#-- @ftlvariable name="config" type="java.util.Properties" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../includes/meta.ftl">
    <title>api.video</title>
</head>

<body>
<div class="container">
    <form action="${config.api_url}/api/videos/uploader" method="get">
        <ul>
            <li>
                <label for="apiKey">API Key:</label>
                <input type="text" id="apiKey" name="api_key">
            </li>
            <li>
                <label for="mail">Customer E-mail:</label>
                <input type="email" id="mail" name="tag">
            </li>
            <li class="button">
                <button type="submit">Submit</button>
            </li>
        </ul>
    </form>
</div>

<#include "../includes/scripts.ftl">

</body>
</html>