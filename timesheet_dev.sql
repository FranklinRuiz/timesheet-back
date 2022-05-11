/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : timesheet_dev

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 11/05/2022 00:13:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for asistencia
-- ----------------------------
DROP TABLE IF EXISTS `asistencia`;
CREATE TABLE `asistencia`  (
  `id_asistencia` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `id_tipo_trabajo` int(11) NOT NULL,
  `id_ubicacion` int(11) NOT NULL,
  `id_dispositivo` int(11) NOT NULL,
  `hora_entrada` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `hora_salida` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `coord_long` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `coord_lat` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `flg_dia_festivo` tinyint(1) NULL DEFAULT 0,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_asistencia`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of asistencia
-- ----------------------------

-- ----------------------------
-- Table structure for cargos
-- ----------------------------
DROP TABLE IF EXISTS `cargos`;
CREATE TABLE `cargos`  (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cargo` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `codigo_cargo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cargo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cargos
-- ----------------------------
INSERT INTO `cargos` VALUES (1, 'programador 2', '001', 0, 'admin', '2021-12-23 22:24:00', 'admin', '2022-01-11 21:55:43');
INSERT INTO `cargos` VALUES (2, 'Diseñador', '002', 1, 'admin', '2021-12-23 22:39:18', 'admin', '2021-12-23 23:40:39');
INSERT INTO `cargos` VALUES (3, 'Repartidor1', '002', 0, 'admin', '2021-12-23 23:23:04', 'admin', '2021-12-23 23:35:32');
INSERT INTO `cargos` VALUES (4, 'sdfsfsfs', '003', 1, 'admin', '2021-12-23 23:39:38', 'admin', '2021-12-23 23:39:38');
INSERT INTO `cargos` VALUES (5, 'asdfsdfgsdg', '004', 1, 'admin', '2021-12-23 23:39:43', 'admin', '2021-12-23 23:39:43');
INSERT INTO `cargos` VALUES (6, 'assdfsdf', '005', 1, 'admin', '2021-12-23 23:39:49', 'admin', '2021-12-23 23:39:49');
INSERT INTO `cargos` VALUES (7, 'asdadasd', '006', 1, 'admin', '2021-12-23 23:39:55', 'admin', '2021-12-23 23:39:55');
INSERT INTO `cargos` VALUES (8, 'asdafdasf', '007', 1, 'admin', '2021-12-23 23:40:01', 'admin', '2021-12-23 23:40:01');
INSERT INTO `cargos` VALUES (9, 'sdafsfsf', '008', 1, 'admin', '2021-12-23 23:40:10', 'admin', '2021-12-23 23:40:45');
INSERT INTO `cargos` VALUES (10, 'asdsadasfd', '009', 1, 'admin', '2021-12-23 23:40:16', 'admin', '2021-12-23 23:40:16');
INSERT INTO `cargos` VALUES (11, 'asfadsfsdf', '010', 1, 'admin', '2021-12-23 23:40:22', 'admin', '2021-12-23 23:40:22');
INSERT INTO `cargos` VALUES (12, 'asfsdfsdf', '011', 1, 'admin', '2021-12-23 23:40:28', 'admin', '2021-12-23 23:40:28');
INSERT INTO `cargos` VALUES (13, 'Secretaria', '002', 1, 'admin', '2021-12-26 22:33:41', 'admin', '2021-12-26 22:33:41');
INSERT INTO `cargos` VALUES (14, 'Gerente', '003', 1, 'admin', '2021-12-26 22:34:28', 'admin', '2021-12-26 22:34:28');
INSERT INTO `cargos` VALUES (15, 'Diseñadora', '003', 1, 'admin', '2022-01-11 21:55:14', 'admin', '2022-01-11 21:55:14');
INSERT INTO `cargos` VALUES (16, 'sfasfafsdfsdf', '0011', 1, 'admin', '2022-01-11 22:02:17', 'admin', '2022-01-11 22:02:17');
INSERT INTO `cargos` VALUES (17, 'sdfsfsf', '05544', 1, 'admin', '2022-02-05 22:44:28', 'admin', '2022-02-05 22:44:28');

-- ----------------------------
-- Table structure for dias_festivos
-- ----------------------------
DROP TABLE IF EXISTS `dias_festivos`;
CREATE TABLE `dias_festivos`  (
  `id_dia_festivo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_dia_festivo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fecha_dia_festivo` date NULL DEFAULT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_dia_festivo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dias_festivos
-- ----------------------------
INSERT INTO `dias_festivos` VALUES (1, 'Prueba de dia festivo', '2022-01-11', 0, 'admin', '2022-01-11 22:30:42', 'admin', '2022-01-11 22:52:31');
INSERT INTO `dias_festivos` VALUES (2, 'santa rosa1', '2022-08-30', 1, 'admin', '2022-01-11 22:52:19', 'admin', '2022-01-11 22:52:24');

-- ----------------------------
-- Table structure for dispositivos
-- ----------------------------
DROP TABLE IF EXISTS `dispositivos`;
CREATE TABLE `dispositivos`  (
  `id_dispositivo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_dispotivo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ip_dispositivo` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `serie` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `codigo` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `modelo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `marca` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_dispositivo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dispositivos
-- ----------------------------

-- ----------------------------
-- Table structure for empleados
-- ----------------------------
DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados`  (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_cargo` int(11) NOT NULL,
  `id_horario` int(11) NOT NULL,
  `codigo_empleado` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `correo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `foto` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_empleado`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empleados
-- ----------------------------

-- ----------------------------
-- Table structure for horarios
-- ----------------------------
DROP TABLE IF EXISTS `horarios`;
CREATE TABLE `horarios`  (
  `id_horario` int(11) NOT NULL AUTO_INCREMENT,
  `hora_inicio` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hora_fin` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_horario`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of horarios
-- ----------------------------

-- ----------------------------
-- Table structure for personas
-- ----------------------------
DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas`  (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_documento` int(11) NULL DEFAULT NULL,
  `numero_documento` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `nombres` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `apellido_paterno` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `apellido_materno` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fecha_nacimiento` date NULL DEFAULT NULL,
  `sexo` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `nombre_completo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_persona`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personas
-- ----------------------------

-- ----------------------------
-- Table structure for sedes
-- ----------------------------
DROP TABLE IF EXISTS `sedes`;
CREATE TABLE `sedes`  (
  `id_sede` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_sede` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `direccion` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `coord_long` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `coord_lat` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_sede`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sedes
-- ----------------------------

-- ----------------------------
-- Table structure for tipo_trabajo
-- ----------------------------
DROP TABLE IF EXISTS `tipo_trabajo`;
CREATE TABLE `tipo_trabajo`  (
  `id_tipo_trabajo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_trabajo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `abreviatura` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `flg_activo` tinyint(1) NULL DEFAULT 1,
  `user_reg` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_reg` datetime(0) NOT NULL,
  `user_upd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date_upd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_trabajo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tipo_trabajo
-- ----------------------------
INSERT INTO `tipo_trabajo` VALUES (1, 'Remoto', 'RM', 1, 'admin', '2021-12-26 23:10:36', 'admin', '2021-12-26 23:10:36');
INSERT INTO `tipo_trabajo` VALUES (2, 'Presencial', 'PR', 1, 'admin', '2021-12-26 23:11:52', 'admin', '2021-12-26 23:11:52');
INSERT INTO `tipo_trabajo` VALUES (3, 'Presencial', 'PR1', 1, 'admin', '2022-01-11 21:54:14', 'admin', '2022-01-11 21:54:14');

SET FOREIGN_KEY_CHECKS = 1;
