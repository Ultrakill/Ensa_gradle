EXEC sp_rename 'Jornada','Jornada_old';
EXEC sp_rename 'Horario','Horario_old';
EXEC sp_rename 'grupo_horario','grupo_horario_old';
EXEC sp_rename 'Bitacora','Bitacora_old';
EXEC sp_rename 'tipo_permiso','tipo_permiso_old';
EXEC sp_rename 'Feriado','Feriado_old';
EXEC sp_rename 'Permiso','Permiso_old';
EXEC sp_rename 'asignacion_permiso','asignacion_permiso_old';
EXEC sp_rename 'asignacion_horario','asignacion_horario_old';
EXEC sp_rename 'detalle_grupo_horario','detalle_grupo_horario_old';
EXEC sp_rename 'saldo_vacacional','saldo_vacacional_old';
EXEC sp_rename 'detalle_registro_asistencia','detalle_registro_asistencia_old';
EXEC sp_rename 'Vacacion','Vacacion_old';
EXEC sp_rename 'registro_asistencia','registro_asistencia_old';