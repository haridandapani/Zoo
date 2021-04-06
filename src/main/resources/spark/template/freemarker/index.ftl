<html>
    <meta charset="UTF-8">
    <title>Zoo</title>
    <a href = "https://github.com/haridandapani/Zoo">GitHub Repository for this project</a><br><br>
    <div id = "demo"></div>
    <script type="text/javascript">
        let redirect = window.location.hostname +"/animal/123";
        document.getElementById("demo").innerHTML = "Animal Specific Page: "+ redirect
    </script>
    <form method = "POST" action="/zoo">
        Minimum Age: <input type = "number" name = "minage" id = "minage"></input><br>
        Maximum Age: <input type = "number" name = "maxage" id = "maxage"></input><br>
        <input type = "submit" value = "Submit"></input>
    </form>
    <p>${content}</p>
</html>