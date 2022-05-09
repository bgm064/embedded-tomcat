<!doctype html>
<html>
<head>
   <title>Sum of two integers</title>
</head>
<body>
    <h1>Input two integers</h1>

    <!-- method määrittelee pyynnön tyypin, joka on oletuksena get -->
    <form method="post" action="/sum">
        <!-- name määrittelee, minkä nimiseen http-parametriin kentän arvo asetetaan -->
        a = <input type="number" name="a" required><br />
        b = <input type="number" name="b" required><br />

        <input type="submit" value="Calculate sum">
    </form>
</body>
</html>