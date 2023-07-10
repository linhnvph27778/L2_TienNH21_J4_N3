<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SNEAKER SHOP</title>
</head>

<style>
    body {
        background-image: url('/images/wall2.png');
        background-size: 100% auto;
        background-position: center center;
        background-attachment: fixed;
    }
    .form {
        background-color: whitesmoke;
        display: block;
        margin-left: 63% ;
        margin-top: 13.5%;
        padding: 1rem;
        width: 70%;
        max-width: 350px;
        border-radius: 0.5rem;
        box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
    }

    .form-title {
        font-size: 1.25rem;
        line-height: 1.75rem;
        font-weight: 600;
        text-align: center;
        color: #834F36;
    }

    .input-container {
        position: relative;
        display: flex;
        margin-bottom: 8px;
    }

    .input-container input,
    .form button {
        outline: none;
        border: 1px solid #834F36;
    }

    .input-container input {
        background-color: #fff;
        padding: 1rem;
        padding-right: 3rem;
        font-size: 0.875rem;
        line-height: 1.25rem;
        width: 100%;
        height: 10px;
        border-radius: 0.5rem;
        box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
    }

    .input-container span {
        display: grid;
        position: absolute;
        top: 0;
        bottom: 0;
        right: 0;
        padding-left: 1rem;
        padding-right: 1rem;
        place-content: center;
    }

    .input-container span svg {
        color: #9CA3AF;
        width: 1rem;
        height: 1rem;
    }

    .submit {
        display: block;
        padding-top: 0.75rem;
        padding-bottom: 0.75rem;
        padding-left: 1.25rem;
        padding-right: 1.25rem;
        background-color: #834F36;
        color: #ffffff;
        font-size: 0.875rem;
        line-height: 1.25rem;
        font-weight: 500;
        width: 100%;
        border-radius: 0.5rem;
        text-transform: uppercase;
    }

    .signup-link {
        color: #582209;
        font-size: 0.875rem;
        line-height: 1.25rem;
        text-align: center;
        margin-top: 11%;
    }

    .signup-link a,
    .link_design a,
    .forgotPassword {
        text-decoration: underline;
    }

    .forgotPassword {
        text-align: center;
        position: relative;
        margin-left: 33%;
        width: 100%;
        bottom: -15px;
        font-size: 0.9rem;
        align-self: center;
        font-weight: bold;
        color: #2c1001;
    }

    .forgotPassword::after {
        position: absolute;
        content: '';
        width: 200%;
        height: 1px;
        bottom: -13px;
        margin-left: -150%;
        background: #040404;
    }

    .forgotPassword:hover {
        text-decoration: underline;
    }

</style>
<body>

<form action="/viewsUsers/authencation/usersLogin" class="form" method="post">

    <p class="form-title">Login in to your account</p>

    <div class="input-container">
        <input placeholder="Username or Email" name="username" type="text">
        <span  style="color: red;">
            <small>${messageEmailErr}</small>
        </span>
    </div>

    <div class="input-container">
        <input placeholder="Password" name="password" type="password" class="form-control">
        <span  style="color: red;">
            <small>${messagePassErr}</small>
        </span>
    </div>

    <button class="submit" type="submit">
        Login
    </button>

    <a class="forgotPassword" href="/viewsUsers/authencation/usersFoggotPass">Forggot Password ?</a>

    <p class="signup-link">
        No Account ?
        <a href="/viewsUsers/authencation/usersRegister">Sign up</a>
    </p>
</form>

</body>
</html>