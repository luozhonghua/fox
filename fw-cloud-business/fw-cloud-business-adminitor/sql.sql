   SELECT
          t3.user_id,
          t3.group_Ids,
          t2.id  AS groupId,
          t2.title  AS groupName
          FROM sys_admin_access t3,sys_admin_group t2 WHERE 1=1 AND t3.user_id=10 AND t3.group_id = t2.id;

SELECT t3.group_Ids FROM sys_admin_access t3  WHERE 1=1 AND t3.user_id=10;



select * from sys_admin_group;

          SELECT
          t2.id  AS groupId,
          t2.title  AS groupName
          FROM  sys_admin_group t2 WHERE
          t2.id in (SELECT   CONVERT(t3.group_Ids,SIGNED)        FROM sys_admin_access t3  WHERE 1=1 AND t3.user_id=10);

SELECT substring_index('www.baidu.com','.', 1);

  /* SELECT
          t3.user_id,
          t2.id  AS groupId,
          t2.title  AS groupName
          FROM  sys_admin_group t2 WHERE
          t2.id in (SELECT  CAST(t3.group_Ids AS SIGNED)   FROM sys_admin_access t3  WHERE 1=1 AND t3.user_id=#{userId});*/


