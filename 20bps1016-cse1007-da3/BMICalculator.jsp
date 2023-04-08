<!DOCTYPE html>
<html>
  <head>
    <title>BMI Calculator</title>
  </head>
  <body>
    <h1>BMI Calculator</h1>
    <form action="bmi.jsp" method="post">
      Height (in cm): <input type="text" name="height" /><br />
      Weight (in kg): <input type="text" name="weight" /><br />
      <input type="submit" value="Calculate" />
    </form>

    <% if (request.getParameter("height") != null &&
    request.getParameter("weight") != null) { double height =
    Double.parseDouble(request.getParameter("height")); double weight =
    Double.parseDouble(request.getParameter("weight")); double bmi = weight /
    ((height / 100) * (height / 100)); String result = ""; if (bmi < 18.5) {
    result = "Underweight"; } else if (bmi < 25) { result = "Normal"; } else if
    (bmi < 30) { result = "Overweight"; } else { result = "Obese"; }
    out.println("
    <h2>BMI Report</h2>
    "); out.println("
    <p>Height: " + request.getParameter("height") + " cm</p>
    "); out.println("
    <p>Weight: " + request.getParameter("weight") + " kg</p>
    "); out.println("
    <p>BMI: " + new DecimalFormat("#.##").format(bmi) + "</p>
    "); out.println("
    <p>Result: " + result + "</p>
    "); } %>
  </body>
</html>
