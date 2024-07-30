SELECT constraint_name 
	from information_schema.constraint_column_usage 
	where table_name = 'users_role'
	and column_name = 'role_id'
	and constraint_name <> 'unique_role_users';

alter table users_role drop CONSTRAINT "uk_cdpd2ix59qroxmqubyjqplxn1";