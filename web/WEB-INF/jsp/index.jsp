<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calc</title>
    </head>
    <body>
		<h1>EsCalc</h1>
        <form action="./" method="POST">
			<input name="value1" type="text" required />
			<input name="value2" type="text" required />
			<div>
				<input type="radio" name="op" value="sum" required /><span>+</span>
				<input type="radio" name="op" value="mult" required /><span>x</span>
			</div>
			<input type="submit" value="Send"/>
		</form>
		<div>Result: ${resultValue}resultValue)</div>
    </body>
</html>
