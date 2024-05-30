# Đây là docs

    link: http://localhost:8089/mywebbapp/

## Cấu hình MySQL

- mysql -u root -p

Nhập password
- use User;
- create table employee (name varchar (255), email varchar(255), password varchar (255));
- insert into employee values('user', 'user@email.com', 'pass');
- insert into employee values('admin', 'admin@email.com','pass');

## File upload

link webshell: 

- http://localhost:8089/mywebbapp/data/shell.jsp
- http://localhost:8089/mywebbapp/normaldata/shell.jsp

## Access control

Truy cập http://localhost:8089/mywebbapp/resources?adminSecretToken=S3cre7 để xem các tài nguyên của admin mà không cần xác thực

