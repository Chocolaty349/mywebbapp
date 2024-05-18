<!DOCTYPE html>
<html>
<%@ page import="jakarta.servlet.*" language="java" session="true" %>
    <head>
        <title>
            welcome page
        </title>
        <style>
            * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

body {
    background: #f7f7f7;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    width: 100%;
    max-width: 600px;
    background: #fff;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

.profile-box {
    text-align: center;
}

.profile-picture img {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    object-fit: cover;
    margin-bottom: 20px;
}

.profile-info {
    text-align: left;
}

.profile-info p {
    margin: 10px 0;
}

.profile-info strong {
    color: #333;
}

        </style>
    </head>
    <body>
    <div class="container">
        <div class="profile-box">
            <h2>Personal Information</h2>
            <div class="profile-picture">
                <img src="profile.jpg" alt="Profile Picture">
            </div>
            <table class="profile-info">
                <tr>
                    <td><strong>Name:</strong></td>
                    <td><%= request.getParameter("username")%></td>
                </tr>
                <tr>
                    <td><strong>Session</strong></td>
                    <td><%=session.getId()%></td>
                </tr>
            </table>
            <button>
                <a href="logout">Logout</a>
            </button>
        </div>
    </div>
</body>
</html>

