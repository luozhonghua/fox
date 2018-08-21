
CREATE FUNCTION `findRole`(targetStr varchar(2000),findStr varchar(2000))
 RETURNS varchar(1000)
	BEGIN
	DECLARE strNum int;
	DECLARE lenIndex int DEFAULT 1;
	DECLARE cStr VARCHAR(50);
	DECLARE flag INT;  -- 标志位
	SET strNum=1+(length(targetStr) - length(replace(targetStr,',','')));
	WHILE lenIndex<=strNum   -- 从一开始循环
	DO
	set cStr=reverse(substring_index(reverse(substring_index(targetStr,',',lenIndex)),',',1));-- 这一步的含义请参考函数分解自己实一下，就明白了
	set flag=FIND_IN_SET(cStr,findStr);
	if (flag>0&&cStr!='') THEN
	RETURN flag;
	END IF;
	set lenIndex=lenIndex+1;
	END WHILE;
	RETURN 0;
END;--并且进行比较