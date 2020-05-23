/* this is table is created by spring-jpa in H2 database
 * create table user (id integer not null, birth_date timestamp, name varchar(255), primary key (id))
 */

--insert into user values(user-id, birth-date, name);
insert into user values(100, sysdate(), 'yolo1');
insert into user values(200, sysdate(), 'yolo2');
insert into user values(300, sysdate(), 'yolo3');

--insert into post values(post-id, post-desc, user-id)
insert into post values(110001, 'my first post', 100);
insert into post values(110002, 'my second post', 100);