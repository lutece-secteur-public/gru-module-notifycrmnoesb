--
-- Table structure for table tf_directory_cf
--
DROP TABLE IF EXISTS task_notify_crm_no_esb_cf;
CREATE TABLE task_notify_crm_no_esb_cf(
  id_task INT DEFAULT NULL,
  status_text varchar(255) DEFAULT  '' NOT NULL,
  id_status_crm INT DEFAULT 0 NOT NULL,
  sender varchar(255) DEFAULT  '' NOT NULL,
  object varchar(255) DEFAULT  '' NOT NULL,
  message LONG VARCHAR,
  is_demand_crm_creation SMALLINT DEFAULT 1 NOT NULL,
  PRIMARY KEY (id_task)
);

