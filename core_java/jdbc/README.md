# Introduction
In this core_java JDBC project, it is aim to create  a connection between Java program and RDBMS such as PostgreSql database. Furthermore, to handle  CRUD implementation based on this JDBC connection. Futhermore, Docker was used to keep containerization on  the project as well as Dbeaver was used to display tables in the hplussport database.

# Implementation
## ER Diagram
![ER_diagram](./assets/ER_diagram.png)

# Design Patterns
During JDBC proh=ject, DAO and repository design pattern were implemented (Repository pattern is only applied for creating different table rather than main project).                                                                         
Dao pattern provides abstraction between JDBC and the rest of the code(specifically business logic). Moreover, DAO comes for two main things which are just abstraction and true object. Dao leverages a common interface and ussually supports multiple tables.
Repository pattern focuses only a single table access per class. Instead of joinning database, it joins in code. In other words; repository pattern allows shading of the database. It makes possible store one piece of data in a seperate database to faciliate disturbution. 

# Test
During testing project;
- Bash script was used for creating database setup in Docker container,
- SQl files was  used to set up table as weel as DBeaver was used to to keep tracking on changing on database, 
- Manuel testing was implemented on JAVA program.
