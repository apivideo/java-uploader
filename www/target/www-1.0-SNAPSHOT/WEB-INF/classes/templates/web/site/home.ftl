<#-- @ftlvariable name="properties" type="java.util.Map<java.lang.String,java.lang.Object>" -->
<#-- @ftlvariable name="config" type="java.util.Properties" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../includes/meta.ftl">
    <title>api.video</title>
</head>

<body>
<main>
    <section>
        <header>
            <img alt="Idea" src="/images/upload.svg" height="200">
            <h2>api.video's Magic Uploader</h2>
            <p>Generate magic link below ↓</p>
        </header>
        <form id="url_generate_form" action="">
            <label for="apiKey">Your API Key: (Available at <a href="https://my.api.video">my.api.video</a>)</label>
            <input type="text" id="apiKey" name="api_key" size="28">
            <label for="tag">Tag: (Unique tag for videos uploaded at the generated URL)</label>
            <input type="text" id="tag" name="tag" size="28" placeholder="Client ID, Email, ticket number...">
            <button type="submit">Submit</button>
            <div id="results" style="max-width: 100%;">
            </div>
        </form>
    </section>
</main>
<#include "../includes/scripts.ftl">
<script type="application/javascript">
    $(document).ready(function () {
        $("#url_generate_form").submit(function () {
                const credentials = {
                    apiKey: $("#apiKey").val(),
                    tag: $("#tag").val()
                };
                $.ajax("${config.api_url}/api/videos/uploader", {
                        data: JSON.stringify(credentials),
                        contentType: 'application/json',
                        type: 'POST',
                        success: function (data) {
                            if (data.success) {
                                document.getElementById("results").innerHTML = '<br><h3>Magic link &mdash;</h3><p><mark><b><a href="' + data.message + '">' + data.message + '</a></b></mark><br></p>';
                            } else {
                                // var $loginMessage = $('#login-message');
                                // $loginMessage.text(data.message);
                                // $loginMessage.show();
                            }
                        }
                    }
                );
                return false;
            }
        );
    });
</script>
</body>
</html>