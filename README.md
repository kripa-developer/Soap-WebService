# 🛠️ Soap-WebService
##  📑 Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Create an XML Schema to Define the Domain](#Create-an-XML-Schema-to-Define-the-Domain)
- [Generate Domain Classes Based on an XML Schema](#Generate-Domain-Classes-Based-on-an-XML-Schema)
- [Example SOAP Request](#example-soap-request)
- [Example SOAP Response](#example-soap-response)
- [Testing with SOAP UI](#testing-with-soap-ui)

## Introduction
This project is a **SOAP-based web service** built using **Spring Boot and JAX-WS**.  
It enables secure and structured XML-based communication between client and server applications over **HTTP**.  

SOAP (Simple Object Access Protocol) is used for exchanging structured information in web services,  
making it ideal for **enterprise applications requiring high security, reliability, and ACID transactions**.

### 🌍 Why SOAP?
- **Protocol-driven**: Ensures **strict** communication standards  
- **Supports WSDL**: Enables **auto-generation** of client stubs  
- **Security**: Supports **WS-Security for authentication & encryption**  
- **Reliability**: Ideal for **banking, telecom, and enterprise applications**  

For more details, see the [WSDL Endpoint](#wsdl-endpoint).
## Features
✔️ SOAP-based communication using WSDL  
✔️ JAX-WS integration with Spring Boot  
✔️ XML-based request/response handling  
✔️ Secure authentication with WS-Security  
✔️ Supports both **document/literal** and **RPC/literal** styles  

## Technologies Used  

| Technology   | Version   |  
|-------------|----------|  
| Java        | 8       |  
| Spring Boot | 2.x      |  
| JAX-WS      | 2.x      |  
| Maven       | Latest   |  
| Tomcat      | Embedded |  

## Installation
🔹 Prerequisites
* Install Java 8 
* Install Maven
* Install Spring Boot
## Usage
To communicate with this SOAP service, clients must send SOAP XML requests to the WSDL endpoint.  
The project needs to include wsdl4j as dependencies in your build file.

## Create an XML Schema to Define the Domain

The web service domain is defined in an XML schema file (XSD) that Spring-WS will automatically export as a WSDL.

## Generate Domain Classes Based on an XML Schema  
The next step is to generate Java classes from the XSD file. The right approach is to do this automatically during build time by using a Maven or Gradle plugin.
