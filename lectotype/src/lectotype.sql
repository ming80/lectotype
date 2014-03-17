CREATE TABLE [limit_switch] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[joint_model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[connection_size] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[explosion_proof] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_limit_switch] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO

CREATE TABLE [solenoid] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[supply_power] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[power_connection] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[air_connection] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[explosion_proof] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_solenoid] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO

CREATE TABLE [actuator] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[_action] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[spring_range] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[air_pressure] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[air_connection] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_actuator] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
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

CREATE TABLE [positioner] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[input_signal] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[air_pressure] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[signal_connection] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[air_connection_size] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[explosion_proof] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_positioner] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO

CREATE TABLE [selected_model] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[name] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[diameter_nominal] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[seat_diameter] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[nominal_pressure] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[flow_open_close] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[air_fail] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[flow_character] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[body_material] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[seat_material] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[plug_material] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[packing] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[bonnet_type] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[connection_flange] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[leakage_class] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_selected_model] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO

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
	[operation_temperature] [varchar] (10) COLLATE Chinese_PRC_CI_AS NULL ,
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
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO

CREATE TABLE [filter_reducing_valve] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[_connection] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_filter_reducing_valve] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO

CREATE TABLE [conveyer] (
	[id] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[model] [varchar] (50) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[output_signal] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[connection_size] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	[explosion_proof] [varchar] (50) COLLATE Chinese_PRC_CI_AS NULL ,
	CONSTRAINT [PK_conveyer] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO
