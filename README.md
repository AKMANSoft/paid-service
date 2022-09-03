# README #

This README would normally document whatever steps are necessary to get your application up and running.

### How do I get set up? ###

* Install Open-JDK 11, Maven 3.5.0
* Step 1: Config mysql connection
    spring.datasource.url=jdbc:mysql://localhost:3306/module_paid
    spring.datasource.username=root
    spring.datasource.password=root
* Step 1: mvn clean install
* Step 2: mvn spring-boot:run
* Step 3: In any browser call : http://localhost:8080
* Login with account : admin/PasSwoRd0101

* Step 4: Call API create client info
Public API :
1/Create client info
curl --location --request POST 'http://localhost:8080/api/public/module-paid' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8FC5EAAB4695BB1D3AA4802F7F1C6DE2' \
--data-raw '{
    "orderNo" : "rufus.hamade+redeemed@gmail.com",
    "clientTin" : "UGFzc23cw2c22m",
    "deviceNo" : "2323223",
    "link" : "https://mail.google.com/mail/u/0/#inbox",
    "status" : "ACTIVE"
}'

2/Check client info
curl --location --request GET 'http://localhost:8080/api/public/module-paid/{clientTin}' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8FC5EAAB4695BB1D3AA4802F7F1C6DE2' \
--data-raw ''





