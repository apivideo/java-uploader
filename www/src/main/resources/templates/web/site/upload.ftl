<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../includes/meta.ftl">
    <title>api.video</title>
</head>

<body>
<form action="${config.api_url}/api/videos/${uniqueURL}">
    <input type="file" id="myFile" name="filename">
    <input type="submit">
</form>
</body>
</html>