<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						function updateInvoiceAndPoints() {
							var itemPrice = parseFloat($('#itemPrice').val());
							var quantity = parseInt($('#quantity').val());

							$.ajax({
								type : 'POST',
								url : 'invoice_servlet',
								data : {
									itemPrice : itemPrice,
									quantity : quantity,
									pid : $('#pid').val(),
									uid : $('#uid').val(),
									date : $('#dates').val(),

								},
								success : function(response) {
									$('#invoiceValue').text(
											response.invoiceValue);
									$('#points').text(response.points);
								},
								error : function(error) {
									console.error('Error updating values:',
											error);
								}
							});
						}

						// Attach event handler to quantity input
						$('#quantity').on('input', updateInvoiceAndPoints);

						$('#buy_now_form').submit(
								function(event) {
									// Prevent default form submission
									event.preventDefault();

									// Get values from form inputs
									var itemPrice = parseFloat($('#itemPrice')
											.val());
									var quantity = parseInt($('#quantity')
											.val());

									// Perform the AJAX call
									$.ajax({
										type : 'POST',
										url : 'invoice_servlet',
										data : {
											itemPrice : itemPrice,
											quantity : quantity,
											pid : $('#pid').val(),
											uid : $('#uid').val(),
											date : $('#dates').val(),
											buyNowButton : 'true'
										},

										success : function(response) {
											$('#invoiceValue').text(
													response.invoiceValue);
											$('#points').text(response.points);
										},
										error : function(error) {
											console.error(
													'Error updating values:',
													error);
										}
									});
								});

						// Initial calculation on page load
						updateInvoiceAndPoints();

						// Set the current date and time 
						var currentDate = new Date();
						var formattedDate = currentDate.toLocaleString('en-US',
								{
									year : 'numeric',
									month : '2-digit',
									day : '2-digit',
									hour : '2-digit',
									minute : '2-digit'
								});
						$('#dates').val(formattedDate);

						// Function to extract URL parameters
						function getParameterByName(name, url) {
							if (!url)
								url = window.location.href;
							name = name.replace(/[\[\]]/g, '\\$&');
							var regex = new RegExp('[?&]' + name
									+ '(=([^&#]*)|&|#|$)'), results = regex
									.exec(url);
							if (!results)
								return null;
							if (!results[2])
								return '';
							return decodeURIComponent(results[2].replace(/\+/g,
									' '));
						}

						// Set values from URL parameters
						$('#pid').val(getParameterByName('id'));
						$('#uid').val(getParameterByName('uid'));
						$('#itemName').val(getParameterByName('name'));
						$('#itemPrice').val(getParameterByName('price'));

					});
</script>
</head>
<body>

	<%
	HttpSession currentSession = request.getSession();
	Integer UIDAttribute = (Integer) currentSession.getAttribute("UID");
	int UID = (UIDAttribute != null) ? UIDAttribute.intValue() : 0;

	String PID = request.getParameter("id");
	%>
	<script>
		var uidValue =
	<%=UID%>
		;
		$(document).ready(function() {
			$('#uid').val(uidValue);
		});
	</script>


	<form id='buy_now_form' action='buy_now' method='post'>
		Product Id <input type='text' name='pid' id='pid'><br>
		Customer Id <input type='text' name='uid' id='uid'><br>
		Item name <input type='text' name='itemName' id='itemName'><br>
		Item Price <input type='text' name='itemPrice' id='itemPrice'><br>
		Quantity <input type='number' name='quantity' id='quantity' min='0'><br>
		Date <input type='text' name='date' id='dates'><br>

		<h4>invoice details</h4>
		<p>
			User ID:
			<%=UID%></p>
		<p>
			Product ID:
			<%=PID%></p>
		<p>
			Invoice Value: $<span id='invoiceValue'>0.00</span>
		</p>
		<p>
			Points: <span id='points'>0</span>
		</p>

		<input type='submit' name='buyNowButton' id='buy_now_button'
			value='Buy now'>
	</form>

</body>
</html>
