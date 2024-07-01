<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Dashboard</title>
  <link rel="icon" href="./images/favicon.ico" type="image/x-icon">

  <%--  Google font--%>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Jost:ital,wght@0,100..900;1,100..900&family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap" rel="stylesheet">

  <link type="text/css" rel="stylesheet" href="css/global.css">
  <link type="text/css" rel="stylesheet" href="css/dashboard.css">
</head>
<body>
  <header>
    <jsp:include page="navbar.jsp"></jsp:include>
  </header>

  <main>
    <section class="container hero-com">
      <div class="hero-part_1">
          <div class="profile">

            <div class="profile-head">
              <div class="avatar">
                <img src="images/my.jpeg" alt="profile picture" />
              </div>
              <p>Fajlay Rabbi</p>
            </div>

            <div class="profile-body">
              <div class="profile-body-income">
                <p>$ 890.8</p>
                <p>Total income</p>
              </div>

              <div class="profile-body-spend">
                <p>$ 478.80</p>
                <p>Total spend</p>
              </div>
            </div>

          </div>


          <div class="ana">
            <p class="ana-txt">Analytics</p>
            <div class="ana-graph" id="anaGraph">
              <%
                double random = Math.random();
              %>
              <img src="<%=request.getContextPath()%>/ExpenseChartServlet?rand=<%=random%>" alt="Expense and Income Chart"/>
            </div>
          </div>
      </div>

      <div class="hero-part_2">
        <div class="ana ex">
          <p class="ana-txt">Expense statistics</p>
          <div class="ana-graph">
            <img src="<%=request.getContextPath()%>/PieChartServlet" alt="Expense and Income Chart"/>
          </div>
        </div>
      </div>
    </section>

    <%--  income history section  --%>
    <section class="container income-sec">
      <div class="income-sec-wrapper">
        <div class="income-sec-title">
          <p>Income History</p>
          <p>+ Add</p>
        </div>

        <div class="income-list-wrapper">
          <jsp:include page="incomeList.jsp"></jsp:include>
          <jsp:include page="incomeList.jsp"></jsp:include>
          <jsp:include page="incomeList.jsp"></jsp:include>
          <jsp:include page="incomeList.jsp"></jsp:include>
        </div>

        <p class="see-all">
          <a href="#" class="See all">Show all</a>
        </p>

      </div>
    </section>

    <%-- category section  --%>
    <section class="container income-sec">
      <div class="cate-sec-wrapper">
        <div class="income-sec-title">
          <p>Categories</p>
          <p>+ Add</p>
        </div>

        <div class="cate-list-wrapper">
          <jsp:include page="categories.jsp"></jsp:include>
          <jsp:include page="categories.jsp"></jsp:include>
          <jsp:include page="categories.jsp"></jsp:include>
          <jsp:include page="categories.jsp"></jsp:include>
          <jsp:include page="categories.jsp"></jsp:include>
          <jsp:include page="categories.jsp"></jsp:include>
          <jsp:include page="categories.jsp"></jsp:include>
          <jsp:include page="categories.jsp"></jsp:include>
        </div>
      </div>
    </section>

    <%-- recent transaction --%>
    <section class="container income-sec">
      <div class="income-sec-wrapper">

        <div class="recent-tran-title">
          <div><p>Recent Transactions</p></div>
          <div>
            <form method="post">
              <select id="type" name="type">
                <option value="" disabled selected>Type</option>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="fiat">Fiat</option>
                <option value="audi">Audi</option>
              </select>

              <select id="categories" name="category">
                <option value="" disabled selected>Category</option>
                <option value="volvo">Volvo</option>
                <option value="saab">Saab</option>
                <option value="fiat">Fiat</option>
                <option value="audi">Audi</option>
              </select>
            </form>
            <p>+ Add</p>
          </div>
        </div>

        <div class="income-list-wrapper">
          <jsp:include page="recentTranc.jsp"></jsp:include>
          <jsp:include page="recentTranc.jsp"></jsp:include>
          <jsp:include page="recentTranc.jsp"></jsp:include>
          <jsp:include page="recentTranc.jsp"></jsp:include>
        </div>
      </div>
    </section>
  </main>


  <div class="container space">
  </div>

<script src="js/Dashboard/dashboard.js"></script>
</body>
</html>
