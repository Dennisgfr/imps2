INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('200', 'employee', '0', '[0],', '员工管理', '', '#', '5', '1', '1', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('201', 'empinfo', '0', '[0],[employee],', '员工信息', '', '/empinfo', '1', '2', '1', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('202', 'employee_list', 'empinfo', '[0],[employee],[empinfo],', '员工列表', '', '/empinfo/list', '1', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('203', 'employee_add', 'empinfo', '[0],[employee],[empinfo],', '员工添加', '', '/empinfo/add', '2', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('204', 'employee_update', 'empinfo', '[0],[employee],[empinfo],', '员工更新', '', '/empinfo/update', '3', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('205', 'employee_delete', 'empinfo', '[0],[employee],[empinfo],', '员工删除', '', '/empinfo/delete', '4', '3', '0', NULL, '1', '0');
INSERT INTO `guns`.`sys_menu` (`id`, `code`, `pcode`, `pcodes`, `name`, `icon`, `url`, `num`, `levels`, `ismenu`, `tips`, `status`, `isopen`) VALUES ('206', 'employee_detail', 'empinfo', '[0],[employee],[empinfo],', '员工详情', '', '/empinfo/detail', '5', '3', '0', NULL, '1', '0');
