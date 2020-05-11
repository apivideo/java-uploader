<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../includes/meta.ftl">
    <title>api.video</title>
</head>

<body>
<header></header>
<main>
    <section>
        <header>
            <img alt="Send" src="/images/sent.svg" height="200">
            <h2>Send me your video!</h2>
            <p>Use the form below ↓</p>
        </header>
        <form id="upload-form" action="" enctype="multipart/form-data">
            <header style="display: none" id="loading-indicator">
                <div class="loadingio-spinner-bean-eater-3u2nawa9eoh">
                    <div class="ldio-35yaxmdwrnd">
                        <div>
                            <div></div>
                            <div></div>
                            <div></div>
                        </div>
                        <div>
                            <div></div>
                            <div></div>
                            <div></div>
                        </div>
                    </div>
                </div>
            </header>
            <input type="file" id="myFile" name="file">
            <br>
            <button id="buttonSubmit" type="submit">Submit</button>
            <div id="results" style="max-width: 100%;">
            </div>
        </form>
    </section>
</main>
<footer></footer>
<#include "../includes/scripts.ftl">
<script type="application/javascript">
    $(document).ready(function () {
        $("#upload-form").submit(function () {
// Get form
                var form = $('#upload-form')[0];
                var data = new FormData(form);
                $("#buttonSubmit").prop("disabled", true);
                $.ajax("${config.api_url}/api/videos/${uniqueURL}", {
                        type: 'POST',
                        enctype: 'multipart/form-data',
                        data: data,
                        processData: false,  // Important!
                        contentType: false,
                        cache: false,
                        timeout: 600000,
                        success: function (data) {
                            document.getElementById("loading-indicator").style.display = "none";
                            document.getElementById("results").innerHTML = '<br><h3>Success! &mdash;</h3><p><mark><b>Your video has been received.</b></mark><br></p>';
                            $("#buttonSubmit").prop("disabled", false);
                        }
                    }
                ).fail(function (data) {
                    document.getElementById("loading-indicator").style.display = "none";
                    document.getElementById("results").innerHTML = '<br><h3>OOPS! Something went wrong. &mdash;</h3><p><mark><b>Please contact the person you got this link from.</b></mark><br></p>';
                    $("#buttonSubmit").prop("disabled", false);
                });
                document.getElementById("loading-indicator").style.display = "block";
                return false;
            }
        );
    });
</script>

<style type="text/css">
    @keyframes ldio-35yaxmdwrnd-1 {
        0% {
            transform: rotate(0deg)
        }
        50% {
            transform: rotate(-45deg)
        }
        100% {
            transform: rotate(0deg)
        }
    }

    @keyframes ldio-35yaxmdwrnd-2 {
        0% {
            transform: rotate(180deg)
        }
        50% {
            transform: rotate(225deg)
        }
        100% {
            transform: rotate(180deg)
        }
    }

    .ldio-35yaxmdwrnd > div:nth-child(2) {
        transform: translate(-15px, 0);
    }

    .ldio-35yaxmdwrnd > div:nth-child(2) div {
        position: absolute;
        top: 40px;
        left: 40px;
        width: 120px;
        height: 60px;
        border-radius: 120px 120px 0 0;
        background: #f8b26a;
        animation: ldio-35yaxmdwrnd-1 1s linear infinite;
        transform-origin: 60px 60px
    }

    .ldio-35yaxmdwrnd > div:nth-child(2) div:nth-child(2) {
        animation: ldio-35yaxmdwrnd-2 1s linear infinite
    }

    .ldio-35yaxmdwrnd > div:nth-child(2) div:nth-child(3) {
        transform: rotate(-90deg);
        animation: none;
    }

    @keyframes ldio-35yaxmdwrnd-3 {
        0% {
            transform: translate(190px, 0);
            opacity: 0
        }
        20% {
            opacity: 1
        }
        100% {
            transform: translate(70px, 0);
            opacity: 1
        }
    }

    .ldio-35yaxmdwrnd > div:nth-child(1) {
        display: block;
    }

    .ldio-35yaxmdwrnd > div:nth-child(1) div {
        position: absolute;
        top: 92px;
        left: -8px;
        width: 16px;
        height: 16px;
        border-radius: 50%;
        background: #e15b64;
        animation: ldio-35yaxmdwrnd-3 1s linear infinite
    }

    .ldio-35yaxmdwrnd > div:nth-child(1) div:nth-child(1) {
        animation-delay: -0.67s
    }

    .ldio-35yaxmdwrnd > div:nth-child(1) div:nth-child(2) {
        animation-delay: -0.33s
    }

    .ldio-35yaxmdwrnd > div:nth-child(1) div:nth-child(3) {
        animation-delay: 0s
    }

    .loadingio-spinner-bean-eater-3u2nawa9eoh {
        width: 200px;
        height: 200px;
        display: inline-block;
        overflow: hidden;
        background: #ffffff;
    }

    .ldio-35yaxmdwrnd {
        width: 100%;
        height: 100%;
        position: relative;
        transform: translateZ(0) scale(1);
        backface-visibility: hidden;
        transform-origin: 0 0; /* see note above */
    }

    .ldio-35yaxmdwrnd div {
        box-sizing: content-box;
    }

    /* generated by https://loading.io/ */
</style>
</body>
</html>