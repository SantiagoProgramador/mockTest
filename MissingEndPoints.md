19. Obtener Todas las Tareas de una Lección
 GET /lessons/{lesson_id}/assignments
 Descripción: Obtener todas las tareas de una lección específica.

23. Obtener Todos los Cursos Inscritos por un Usuario
 GET /users/{user_id}/courses
 Descripción: Obtener todos los cursos en los que está inscrito un usuario
específico.

24. Obtener Todos los Usuarios Inscritos en un Curso
 GET /courses/{course_id}/users
 Descripción: Obtener todos los usuarios inscritos en un curso específico.

29. Obtener Todas las Entregas de una Tarea
 GET /assignments/{assignment_id}/submissions
 Descripción: Obtener todas las entregas de una tarea específica.

30. Obtener Todas las Entregas de un Usuario
 GET /users/{user_id}/submissions
 Descripción: Obtener todas las entregas de un usuario específico.

37. Obtener Mensajes de un Curso
 GET /courses/{course_id}/messages
 Descripción: Obtener todos los mensajes de un curso específico.

38. Obtener Mensajes entre Usuarios
 GET /messages?sender_id={sender_id}&receiver_id={receiver_id}
 Descripción: Obtener todos los mensajes entre dos usuarios específicos.