<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Feedback Form</title>
    <%@include file="comp/links.jsp" %> <!-- Ensure this includes necessary CSS files (Bootstrap, etc.) -->
  </head>
  <body>
    <%@include file="header.jsp" %> <!-- Header inclusion -->

    <div class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
      <h1 class="text-white">Fill the Feedback Form</h1>
      <form action="<%=application.getContextPath() %>/feedback" method="post" class="mt-3 text-white">

        <!-- Email Field -->
        <div class="mb-3">
          <label for="email" class="form-label">Email address</label>
          <input placeholder="Enter here" name="email" type="email" class="form-control" id="email" required>
          <div id="emailHelp" class="form-text text-white">We'll never share your email with anyone else.</div>
        </div>

        <!-- Phone Number Field -->
        <div class="mb-3">
          <label for="phone" class="form-label">Phone Number</label>
          <input name="phone" type="text" class="form-control" id="phone" required>
        </div>

        <!-- Feedback Message -->
        <div class="mb-3">
          <label for="message" class="form-label">Your Feedback Message</label>
          <textarea name="feedback_message" rows="5" placeholder="Enter here" class="form-control" id="message" required></textarea>
        </div>

        <!-- Submit and Reset Buttons -->
        <div class="container text-center">
          <button type="submit" class="btn btn-warning">Submit</button>
          <button type="reset" class="btn btn-light">Reset</button>
        </div>

      </form>
    </div>

    <%@include file="script.jsp" %> <!-- JavaScript includes -->
  </body>
</html>
