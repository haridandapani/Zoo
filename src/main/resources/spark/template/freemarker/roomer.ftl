<html>
    <meta charset="UTF-8">
    <title>📜 ListPicker by Hari</title>
    <link rel="stylesheet" href="static/css/style.css">
    <script>
    tempers = [];
    found = [];
    function clearTempers(){
        tempers = [];
    }
    function addToTempers(item){
        tempers.push(item);
    }
    function updateMovies(event){
        if (found.length < tempers.length - 2){
            found.push(event.target.id);
            //let numID = parseInt(event.target.id.replace("movie",""), 10);
            elem = document.getElementById(event.target.id);
            elem.parentNode.removeChild(elem);
            const postParameters = {};
            $.post("/nextPerson", postParameters, response => {
                const jsonRes = JSON.parse(response)
                newbie = jsonRes.newbie;
                document.getElementById("eliminator").innerHTML = newbie;
            });
        } else{
            if (found.length == tempers.length - 2){
                found.push(event.target.id);
                elem = document.getElementById(event.target.id);
                elem.parentNode.removeChild(elem);
            }
            document.getElementById("eliminator").innerHTML = "Congratulations! You have selected:";
            document.getElementById("instructions").innerHTML = "";
            elem = document.getElementById("decline");
            elem.parentNode.removeChild(elem);
        }
    }
    function decline(event){
        const postParameters = {};
        $.post("/nextPerson", postParameters, response => {
            const jsonRes = JSON.parse(response)
            newbie = jsonRes.newbie;
            document.getElementById("eliminator").innerHTML = newbie;
        });
    }
    </script>
    <div class = "sticky">
        <h1 id = "eliminator" align = "center" >${person}</h1>
    </div>
    <hr>
    <br>
    <#if movies??>
    <script>
        clearTempers();
    </script>
    </#if>
    <#list movies as movie>
    <script>
        addToTempers("${movie}");
    </script>
    </#list>

    <div id = "allmovies">
    </div>

    <script>
        text = ""
        for (var i = 0; i < tempers.length; i++) {
            text += "<button class=\"block\" onclick = \"updateMovies(event)\" id=movie"+i+">"+tempers[i] + "</button>";
        }
        text += "<button class=\"blocktwo\" onclick = \"decline(event)\" id=decline>I decline to act</button>";
        document.getElementById("allmovies").innerHTML = text;
    </script>
    <div id = "instructions">
        <h4>Select an item to eliminate it.</h4>
    </div>
    <div align = "center">
        <a href = "/" class = "homer">Go Home</a>
    </div>



    <script type="text/javascript" src="static/js/selector.js"></script>
    <script type="text/javascript" src = "static/js/jquery-3.1.1.js"></script>

</html>