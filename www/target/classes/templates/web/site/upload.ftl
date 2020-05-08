<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../includes/meta.ftl">
    <title>api.video</title>
</head>

<body>
<form action="${config.api_url}/api/videos/${uniqueURL}" method="post" enctype="multipart/form-data">
    <input type="file" id="myFile" name="file">
    <input type="submit">
</form>
</body>
</html>