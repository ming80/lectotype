CREATE TABLE [valve_specification] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[project_name] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[tag_No] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[quantity] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[service] [varchar] (200) COLLATE Chinese_PRC_CI_AS NULL ,
	[remarks] [varchar] (500) COLLATE Chinese_PRC_CI_AS NULL ,
	[pipe_size_and_material] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[fluid_state] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[fluid_name] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[density] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[flow_unit] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[Qmax] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[Qnor] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[Qmin] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[opration_temperature] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[pressure_unit] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[upstream_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[downstream_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[differential_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[dynamic_viscosity] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[compress_factor] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[vapor_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[critical_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[kv_max] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[kv_min] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[selected_kv] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[adjustable_ratio] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[flow_characteristic] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[k_max] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[k_min] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[nominal_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[noise_level] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[close_open] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[selected_model_name] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[selected_model_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[diameter_nominal] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[seat_diameter] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[selected_model_nominal_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[flow_open_close] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[air_fail] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
	[flow_character] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[body_material] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[seat_material] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[plug_material] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[packing] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[bonnet_type] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[connection_flange] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[leakage_class] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[actuator_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[actuator_action] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[spring_range] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[actuator_air_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[actuator_air_connection] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[positioner_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[positioner_input_signal] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[positioner_air_pressure] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[positioner_signal_connection] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[positioner_air_connection_size] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[positioner_explosion_proof] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[solenoid_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[solenoid_supply_power] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[solenoid_power_connection] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[solenoid_air_connection] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[solenoid_explosion_proof] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[limit_switch_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[limit_switch_joint_model] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[limit_switch_connection_size] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[limit_switch_explosion_proof] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[conveyer_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[conveyer_output_signal] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[conveyer_connection_size] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[conveyer_explosion_proof] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[filter_reducing_valve_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[filter_reducing_valve_connection] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[hand_wheel] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_valve_specification] PRIMARY KEY  CLUSTERED 
	([id])  ON [PRIMARY] 
) ON [PRIMARY]
GO

CREATE TABLE [fluid] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[name] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[state] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[density] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[sg] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_fluid] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO




--insert into valve_specification       (id,project_name,tag_No,quantity,service,remarks,pipe_size_and_material,fluid_state,      fluid_name,density,flow_unit,Qmax,Qnor,Qmin,opration_temperature,pressure_unit,      upstream_pressure,downstream_pressure,differential_pressure,dynamic_viscosity,      compress_factor,vapor_pressure,critical_pressure,kv_max,kv_min,selected_kv,      adjustable_ratio,flow_characteristic,k_max,k_min,nominal_pressure,noise_level,      close_open,selected_model_name,selected_model_model,diameter_nominal,seat_diameter,      selected_model_nominal_pressure,flow_open_close,air_fail,flow_character,body_material,      seat_material,plug_material,packing,bonnet_type,connection_flange,leakage_class,      actuator_model,actuator_action,spring_range,actuator_air_pressure,actuator_air_connection,      positioner_model,positioner_input_signal,positioner_air_pressure,positioner_signal_connection,      positioner_air_connection_size,positioner_explosion_proof,solenoid_model,solenoid_supply_power,      solenoid_power_connection,solenoid_air_connection,solenoid_explosion_proof,limit_switch_model,      limit_switch_joint_model,limit_switch_connection_size,limit_switch_explosion_proof,conveyer_model,      conveyer_output_signal,conveyer_connection_size,conveyer_explosion_proof,      filter_reducing_valve_model,filter_reducing_valve_connection,hand_wheel)   
--values('1','2','3','4','5','6','7','8','9','10','11',   '12','13','14','15',   '16','17','18',   '19','20','21',   '22','23','24',   '25','26','27',   '28','29','30',   '31','32','33',   '34','35','36',   '37','38','39',   '40','41','42',   '43','44','45',   '46','47','48',   '49','50','51','52',   '53','54','55',   '56','57',   '58','59',   '60','61','62',   '63','64',   '65','66',   '67','68',   '69','70','71',   '72','73',   '74','75')

