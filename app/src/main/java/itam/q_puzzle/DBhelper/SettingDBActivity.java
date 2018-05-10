package itam.q_puzzle.DBhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import id.mromadloni.q_puzzle.R;
import itam.q_puzzle.activity.MenuUtamaActivity;
import itam.q_puzzle.model.BlokKosong;
import itam.q_puzzle.model.Kata;
import itam.q_puzzle.model.Level;
import itam.q_puzzle.model.Settings;
import itam.q_puzzle.model.Surat;

/**
 * Created by Muslim muslim on 4/10/2018.
 */
public class SettingDBActivity extends Activity {

    // Database Helper
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_db);

        db = new DatabaseHelper(getApplicationContext());

        // Creating Surat
        Surat surat114 = new Surat(114, "AN-NAS", 6, 20, 1);
        Surat surat113 = new Surat(113, "AL-FALAQ", 5, 23, 2);
        Surat surat112 = new Surat(112, "AL-'IKHLAS", 4, 15, 3);
        Surat surat111 = new Surat(111, "AL-MASAD", 5, 23, 4);
        Surat surat110 = new Surat(110, "AN-NASR", 3, 19, 5);
        Surat surat109 = new Surat(109, "AL-KAFIRUN", 6, 26, 6);
        Surat surat108 = new Surat(108, "AL-KAWTHAR", 3, 10, 7);
        Surat surat107 = new Surat(107, "AL-MA'UN", 7, 25, 8);
        Surat surat106 = new Surat(106, "QURAYSH", 4, 17, 9);
        Surat surat105 = new Surat(105, "AL-FIL", 5, 23, 10);
        Surat surat104 = new Surat(104, "AL-HUMAZAH", 9, 33, 11);
        Surat surat103 = new Surat(103, "AL-ASR", 3, 14, 12);
        Surat surat102 = new Surat(102, "AL-TAKASUR", 8, 28, 13);
        Surat surat101 = new Surat(101, "AL-QORIAH", 11, 36, 14);
        Surat surat100 = new Surat(100, "AL-ADIYAT", 11, 29, 15);

        // Inserting Surat in db
        long surat114_id = db.createSurat(surat114);
        long surat113_id = db.createSurat(surat113);
        long surat112_id = db.createSurat(surat112);
        long surat111_id = db.createSurat(surat111);
        long surat110_id = db.createSurat(surat110);
        long surat109_id = db.createSurat(surat109);
        long surat108_id = db.createSurat(surat108);
        long surat107_id = db.createSurat(surat107);
        long surat106_id = db.createSurat(surat106);
        long surat105_id = db.createSurat(surat105);
        long surat104_id = db.createSurat(surat104);
        long surat103_id = db.createSurat(surat103);
        long surat102_id = db.createSurat(surat102);
        long surat101_id = db.createSurat(surat101);
        long surat100_id = db.createSurat(surat100);

        Log.d("Surat Count", "Surat Count: " + db.getAllSurat().size());

        // Creating Level
        Level level1 = new Level(1, "MUDAH", 1);
        Level level2 = new Level(2, "NORMAL", 3);
        Level level3 = new Level(3, "SULIT", 5);

        // Inserting Level in db
        long level1_id = db.createLevel(level1);
        long level2_id = db.createLevel(level2);
        long level3_id = db.createLevel(level3);

        Log.d("Level Count", "Level Count: " + db.getAllLevel().size());

        // Creating Kata
        // 114 - an-Nas
        Kata kata1140101 = new Kata(1, 114, 1, 1, "1140101", 1);
        Kata kata1140102 = new Kata(2, 114, 1, 2, "1140102", 2);
        Kata kata1140103 = new Kata(3, 114, 1, 3, "1140103", 3);
        Kata kata1140104 = new Kata(4, 114, 1, 4, "114xx01", 4);
        Kata kata1140201 = new Kata(5, 114, 2, 1, "1140201", 5);
        Kata kata1140202 = new Kata(6, 114, 2, 2, "114xx01", 6);
        Kata kata1140301 = new Kata(7, 114, 3, 1, "1140301", 7);
        Kata kata1140302 = new Kata(8, 114, 3, 2, "114xx01", 8);
        Kata kata1140401 = new Kata(9, 114, 4, 1, "1140401", 9);
        Kata kata1140402 = new Kata(10, 114, 4, 2, "1140402", 10);
        Kata kata1140403 = new Kata(11, 114, 4, 3, "1140403", 11);
        Kata kata1140404 = new Kata(12, 114, 4, 4, "1140404", 12);
        Kata kata1140501 = new Kata(13, 114, 5, 1, "1140501", 13);
        Kata kata1140502 = new Kata(14, 114, 5, 2, "1140502", 14);
        Kata kata1140503 = new Kata(15, 114, 5, 3, "1140503", 15);
        Kata kata1140504 = new Kata(16, 114, 5, 4, "1140504", 16);
        Kata kata1140505 = new Kata(17, 114, 5, 5, "114xx01", 17);
        Kata kata1140601 = new Kata(18, 114, 6, 1, "1140601", 18);
        Kata kata1140602 = new Kata(19, 114, 6, 2, "1140602", 19);
        Kata kata1140603 = new Kata(20, 114, 6, 3, "1140603", 20);

        // 113 - al-Falaq
        Kata kata1130101 = new Kata(21, 113, 1, 1, "1130101", 1);
        Kata kata1130102 = new Kata(22, 113, 1, 2, "1130102", 2);
        Kata kata1130103 = new Kata(23, 113, 1, 3, "1130103", 3);
        Kata kata1130104 = new Kata(24, 113, 1, 4, "1130104", 4);
        Kata kata1130201 = new Kata(25, 113, 2, 1, "1130201", 5);
        Kata kata1130202 = new Kata(26, 113, 2, 2, "113xx01", 6);
        Kata kata1130203 = new Kata(27, 113, 2, 3, "1130203", 7);
        Kata kata1130204 = new Kata(28, 113, 2, 4, "1130204", 8);
        Kata kata1130301 = new Kata(29, 113, 3, 1, "113xx02", 9);
        Kata kata1130302 = new Kata(30, 113, 3, 2, "113xx01", 10);
        Kata kata1130303 = new Kata(31, 113, 3, 3, "1130303", 11);
        Kata kata1130304 = new Kata(32, 113, 3, 4, "113xx03", 12);
        Kata kata1130305 = new Kata(33, 113, 3, 5, "1130305", 13);
        Kata kata1130401 = new Kata(34, 113, 4, 1, "113xx02", 14);
        Kata kata1130402 = new Kata(35, 113, 4, 2, "113xx01", 15);
        Kata kata1130403 = new Kata(36, 113, 4, 3, "1130403", 16);
        Kata kata1130404 = new Kata(37, 113, 4, 4, "1130404", 17);
        Kata kata1130405 = new Kata(38, 113, 4, 5, "1130405", 18);
        Kata kata1130501 = new Kata(39, 113, 5, 1, "113xx02", 19);
        Kata kata1130502 = new Kata(40, 113, 5, 2, "113xx01", 20);
        Kata kata1130503 = new Kata(41, 113, 5, 3, "1130503", 21);
        Kata kata1130504 = new Kata(42, 113, 5, 4, "113xx03", 22);
        Kata kata1130505 = new Kata(43, 113, 5, 5, "1130505", 23);

        // 112 - al-Ikhlas
        Kata kata1120101 = new Kata(44, 112, 1, 1, "1120101", 1);
        Kata kata1120102 = new Kata(45, 112, 1, 2, "1120102", 2);
        Kata kata1120103 = new Kata(46, 112, 1, 3, "112xx01", 3);
        Kata kata1120104 = new Kata(47, 112, 1, 4, "1120104", 4);
        Kata kata1120201 = new Kata(48, 112, 2, 1, "112xx01", 5);
        Kata kata1120202 = new Kata(49, 112, 2, 2, "1120202", 6);
        Kata kata1120301 = new Kata(50, 112, 3, 1, "1120301", 7);
        Kata kata1120302 = new Kata(51, 112, 3, 2, "1120302", 8);
        Kata kata1120303 = new Kata(52, 112, 3, 3, "112xx02", 9);
        Kata kata1120304 = new Kata(53, 112, 3, 4, "1120304", 10);
        Kata kata1120401 = new Kata(54, 112, 4, 1, "112xx02", 11);
        Kata kata1120402 = new Kata(55, 112, 4, 2, "1120402", 12);
        Kata kata1120403 = new Kata(56, 112, 4, 3, "1120403", 13);
        Kata kata1120404 = new Kata(57, 112, 4, 4, "1120404", 14);
        Kata kata1120405 = new Kata(58, 112, 4, 5, "1120405", 15);

        // 111 - al-Masad
        Kata kata1110101 = new Kata(59, 111, 1, 1, "1110101", 1);
        Kata kata1110102 = new Kata(60, 111, 1, 2, "1110102", 2);
        Kata kata1110103 = new Kata(61, 111, 1, 3, "1110103", 3);
        Kata kata1110104 = new Kata(62, 111, 1, 4, "111xx01", 4);
        Kata kata1110105 = new Kata(63, 111, 1, 5, "1110105", 5);
        Kata kata1110201 = new Kata(64, 111, 2, 1, "1110201", 6);
        Kata kata1110202 = new Kata(65, 111, 2, 2, "1110202", 7);
        Kata kata1110203 = new Kata(66, 111, 2, 3, "1110203", 8);
        Kata kata1110204 = new Kata(67, 111, 2, 4, "1110204", 9);
        Kata kata1110205 = new Kata(68, 111, 2, 5, "1110205", 10);
        Kata kata1110206 = new Kata(69, 111, 2, 6, "1110206", 11);
        Kata kata1110301 = new Kata(70, 111, 3, 1, "1110301", 12);
        Kata kata1110302 = new Kata(71, 111, 3, 2, "1110302", 13);
        Kata kata1110303 = new Kata(72, 111, 3, 3, "1110303", 14);
        Kata kata1110304 = new Kata(73, 111, 3, 4, "111xx01", 15);
        Kata kata1110401 = new Kata(74, 111, 4, 1, "1110401", 16);
        Kata kata1110402 = new Kata(75, 111, 4, 2, "1110402", 17);
        Kata kata1110403 = new Kata(76, 111, 4, 3, "1110403", 18);
        Kata kata1110501 = new Kata(77, 111, 5, 1, "1110501", 19);
        Kata kata1110502 = new Kata(78, 111, 5, 2, "1110502", 20);
        Kata kata1110503 = new Kata(79, 111, 5, 3, "1110503", 21);
        Kata kata1110504 = new Kata(80, 111, 5, 4, "1110504", 22);
        Kata kata1110505 = new Kata(81, 111, 5, 5, "1110505", 23);

        // 110 - an-Nasr
        Kata kata1100101 = new Kata(82, 110, 1, 1, "1100101", 1);
        Kata kata1100102 = new Kata(83, 110, 1, 2, "1100102", 2);
        Kata kata1100103 = new Kata(84, 110, 1, 3, "1100103", 3);
        Kata kata1100104 = new Kata(85, 110, 1, 4, "110xx01", 4);
        Kata kata1100105 = new Kata(86, 110, 1, 5, "1100105", 5);
        Kata kata1100201 = new Kata(87, 110, 2, 1, "1100201", 6);
        Kata kata1100202 = new Kata(88, 110, 2, 2, "1100202", 7);
        Kata kata1100203 = new Kata(89, 110, 2, 3, "1100203", 8);
        Kata kata1100204 = new Kata(90, 110, 2, 4, "1100204", 9);
        Kata kata1100205 = new Kata(91, 110, 2, 5, "1100205", 10);
        Kata kata1100206 = new Kata(92, 110, 2, 6, "110xx01", 11);
        Kata kata1100207 = new Kata(93, 110, 2, 7, "1100207", 12);
        Kata kata1100301 = new Kata(94, 110, 3, 1, "1100301", 13);
        Kata kata1100302 = new Kata(95, 110, 3, 2, "1100302", 14);
        Kata kata1100303 = new Kata(96, 110, 3, 3, "1100303", 15);
        Kata kata1100304 = new Kata(97, 110, 3, 4, "1100304", 16);
        Kata kata1100305 = new Kata(98, 110, 3, 5, "1100305", 17);
        Kata kata1100306 = new Kata(99, 110, 3, 6, "1100306", 18);
        Kata kata1100307 = new Kata(100, 110, 3, 7, "1100307", 19);

        // 109 - al-Kafirun
        Kata kata1090101 = new Kata(101, 109, 1, 1, "1090101", 1);
        Kata kata1090102 = new Kata(102, 109, 1, 2, "1090102", 2);
        Kata kata1090103 = new Kata(103, 109, 1, 3, "1090103", 3);
        Kata kata1090201 = new Kata(104, 109, 2, 1, "1090201", 4);
        Kata kata1090202 = new Kata(105, 109, 2, 2, "109xx01", 5);
        Kata kata1090203 = new Kata(106, 109, 2, 3, "1090203", 6);
        Kata kata1090204 = new Kata(107, 109, 2, 4, "1090204", 7);
        Kata kata1090301 = new Kata(108, 109, 3, 1, "109xx02", 8);
        Kata kata1090302 = new Kata(109, 109, 3, 2, "109xx03", 9);
        Kata kata1090303 = new Kata(110, 109, 3, 3, "109xx04", 10);
        Kata kata1090304 = new Kata(111, 109, 3, 4, "109xx05", 11);
        Kata kata1090305 = new Kata(112, 109, 3, 5, "109xx01", 12);
        Kata kata1090401 = new Kata(113, 109, 4, 1, "109xx02", 13);
        Kata kata1090402 = new Kata(114, 109, 4, 2, "1090402", 14);
        Kata kata1090403 = new Kata(115, 109, 4, 3, "1090403", 15);
        Kata kata1090404 = new Kata(116, 109, 4, 4, "1090404", 16);
        Kata kata1090405 = new Kata(117, 109, 4, 5, "1090405", 17);
        Kata kata1090501 = new Kata(118, 109, 5, 1, "109xx02", 18);
        Kata kata1090502 = new Kata(119, 109, 5, 2, "109xx03", 19);
        Kata kata1090503 = new Kata(120, 109, 5, 3, "109xx04", 20);
        Kata kata1090504 = new Kata(121, 109, 5, 4, "109xx05", 21);
        Kata kata1090505 = new Kata(122, 109, 5, 5, "109xx01", 22);
        Kata kata1090601 = new Kata(123, 109, 6, 1, "1090601", 23);
        Kata kata1090602 = new Kata(124, 109, 6, 2, "1090602", 24);
        Kata kata1090603 = new Kata(125, 109, 6, 3, "1090603", 25);
        Kata kata1090604 = new Kata(126, 109, 6, 4, "1090604", 26);

        // 108 - al-Kawthar
        Kata kata1080101 = new Kata(127, 108, 1, 1, "1080101", 1);
        Kata kata1080102 = new Kata(128, 108, 1, 2, "1080102", 2);
        Kata kata1080103 = new Kata(129, 108, 1, 3, "1080103", 3);
        Kata kata1080201 = new Kata(130, 108, 2, 1, "1080201", 4);
        Kata kata1080202 = new Kata(131, 108, 2, 2, "1080202", 5);
        Kata kata1080203 = new Kata(132, 108, 2, 3, "1080203", 6);
        Kata kata1080301 = new Kata(133, 108, 3, 1, "1080301", 7);
        Kata kata1080302 = new Kata(134, 108, 3, 2, "1080302", 8);
        Kata kata1080303 = new Kata(135, 108, 3, 3, "1080303", 9);
        Kata kata1080304 = new Kata(136, 108, 3, 4, "1080304", 10);

        // 107 - al-Ma'un
        Kata kata1070101 = new Kata(137, 107, 1, 1, "1070101", 1);
        Kata kata1070102 = new Kata(138, 107, 1, 2, "107xx01", 2);
        Kata kata1070103 = new Kata(139, 107, 1, 3, "1070103", 3);
        Kata kata1070104 = new Kata(140, 107, 1, 4, "1070104", 4);
        Kata kata1070201 = new Kata(141, 107, 2, 1, "1070201", 5);
        Kata kata1070202 = new Kata(142, 107, 2, 2, "107xx01", 6);
        Kata kata1070203 = new Kata(143, 107, 2, 3, "1070203", 7);
        Kata kata1070204 = new Kata(144, 107, 2, 4, "1070204", 8);
        Kata kata1070301 = new Kata(145, 107, 3, 1, "1070301", 9);
        Kata kata1070302 = new Kata(146, 107, 3, 2, "1070302", 10);
        Kata kata1070303 = new Kata(147, 107, 3, 3, "1070303", 11);
        Kata kata1070304 = new Kata(148, 107, 3, 4, "1070304", 12);
        Kata kata1070305 = new Kata(149, 107, 3, 5, "1070305", 13);
        Kata kata1070401 = new Kata(150, 107, 4, 1, "1070401", 14);
        Kata kata1070402 = new Kata(151, 107, 4, 2, "1070402", 15);
        Kata kata1070501 = new Kata(152, 107, 5, 1, "107xx02", 16);
        Kata kata1070502 = new Kata(153, 107, 5, 2, "107xx03", 17);
        Kata kata1070503 = new Kata(154, 107, 5, 3, "1070503", 18);
        Kata kata1070504 = new Kata(155, 107, 5, 4, "1070504", 19);
        Kata kata1070505 = new Kata(156, 107, 5, 5, "1070505", 20);
        Kata kata1070601 = new Kata(157, 107, 6, 1, "107xx02", 21);
        Kata kata1070602 = new Kata(158, 107, 6, 2, "107xx03", 22);
        Kata kata1070603 = new Kata(159, 107, 6, 3, "1070603", 23);
        Kata kata1070701 = new Kata(160, 107, 7, 1, "1070701", 24);
        Kata kata1070702 = new Kata(161, 107, 7, 2, "1070702", 25);

        // 106 - Quraysh
        Kata kata1060101 = new Kata(162, 106, 1, 1, "1060101", 1);
        Kata kata1060102 = new Kata(163, 106, 1, 2, "1060102", 2);
        Kata kata1060201 = new Kata(164, 106, 2, 1, "1060201", 3);
        Kata kata1060202 = new Kata(165, 106, 2, 2, "1060202", 4);
        Kata kata1060203 = new Kata(166, 106, 2, 3, "1060203", 5);
        Kata kata1060204 = new Kata(167, 106, 2, 4, "1060204", 6);
        Kata kata1060301 = new Kata(168, 106, 3, 1, "1060301", 7);
        Kata kata1060302 = new Kata(169, 106, 3, 2, "1060302", 8);
        Kata kata1060303 = new Kata(170, 106, 3, 3, "1060303", 9);
        Kata kata1060304 = new Kata(171, 106, 3, 4, "1060304", 10);
        Kata kata1060401 = new Kata(172, 106, 4, 1, "1060401", 11);
        Kata kata1060402 = new Kata(173, 106, 4, 2, "1060402", 12);
        Kata kata1060403 = new Kata(174, 106, 4, 3, "106xx01", 13);
        Kata kata1060404 = new Kata(175, 106, 4, 4, "1060404", 14);
        Kata kata1060405 = new Kata(176, 106, 4, 5, "1060405", 15);
        Kata kata1060406 = new Kata(177, 106, 4, 6, "106xx01", 16);
        Kata kata1060407 = new Kata(178, 106, 4, 7, "1060407", 17);

        // 105 - al-Fil
        Kata kata1050101 = new Kata(179, 105, 1, 1, "105xx01", 1);
        Kata kata1050102 = new Kata(180, 105, 1, 2, "1050102", 2);
        Kata kata1050103 = new Kata(181, 105, 1, 3, "1050103", 3);
        Kata kata1050104 = new Kata(182, 105, 1, 4, "1050104", 4);
        Kata kata1050105 = new Kata(183, 105, 1, 5, "1050105", 5);
        Kata kata1050106 = new Kata(184, 105, 1, 6, "1050106", 6);
        Kata kata1050107 = new Kata(185, 105, 1, 7, "1050107", 7);
        Kata kata1050201 = new Kata(186, 105, 2, 1, "105xx01", 8);
        Kata kata1050202 = new Kata(187, 105, 2, 2, "1050202", 9);
        Kata kata1050203 = new Kata(188, 105, 2, 3, "1050203", 10);
        Kata kata1050204 = new Kata(189, 105, 2, 4, "1050204", 11);
        Kata kata1050205 = new Kata(190, 105, 2, 5, "1050205", 12);
        Kata kata1050301 = new Kata(191, 105, 3, 1, "1050301", 13);
        Kata kata1050302 = new Kata(192, 105, 3, 2, "1050302", 14);
        Kata kata1050303 = new Kata(193, 105, 3, 3, "1050303", 15);
        Kata kata1050304 = new Kata(194, 105, 3, 4, "1050304", 16);
        Kata kata1050401 = new Kata(195, 105, 4, 1, "1050401", 17);
        Kata kata1050402 = new Kata(196, 105, 4, 2, "1050402", 18);
        Kata kata1050403 = new Kata(197, 105, 4, 3, "1050403", 19);
        Kata kata1050404 = new Kata(198, 105, 4, 4, "1050404", 20);
        Kata kata1050501 = new Kata(199, 105, 5, 1, "1050501", 21);
        Kata kata1050502 = new Kata(200, 105, 5, 2, "1050502", 22);
        Kata kata1050503 = new Kata(201, 105, 5, 3, "1050503", 23);

        // 104 - al-humazah
        Kata kata1040101 = new Kata(202, 104, 1, 1, "1040101", 1);
        Kata kata1040102 = new Kata(203, 104, 1, 2, "1040102", 2);
        Kata kata1040103 = new Kata(204, 104, 1, 3, "1040103", 3);
        Kata kata1040104 = new Kata(205, 104, 1, 4, "1040104", 4);
        Kata kata1040201 = new Kata(206, 104, 2, 1, "1040201", 5);
        Kata kata1040202 = new Kata(207, 104, 2, 2, "1040202", 6);
        Kata kata1040203 = new Kata(208, 104, 2, 3, "1040203", 7);
        Kata kata1040204 = new Kata(209, 104, 2, 4, "1040204", 8);
        Kata kata1040301 = new Kata(210, 104, 3, 1, "1040301", 9);
        Kata kata1040302 = new Kata(211, 104, 3, 2, "1040302", 10);
        Kata kata1040303 = new Kata(212, 104, 3, 3, "1040303", 11);
        Kata kata1040304 = new Kata(213, 104, 3, 4, "1040304", 12);
        Kata kata1040401 = new Kata(214, 104, 4, 1, "1040401", 13);
        Kata kata1040402 = new Kata(215, 104, 4, 2, "1040402", 14);
        Kata kata1040403 = new Kata(216, 104, 4, 3, "1040403", 15);
        Kata kata1040404 = new Kata(217, 104, 4, 4, "1040404", 16);
        Kata kata1040501 = new Kata(218, 104, 5, 1, "1040501", 17);
        Kata kata1040502 = new Kata(219, 104, 5, 2, "1040502", 18);
        Kata kata1040503 = new Kata(220, 104, 5, 3, "1040503", 19);
        Kata kata1040504 = new Kata(221, 104, 5, 4, "1040504", 20);
        Kata kata1040601 = new Kata(222, 104, 6, 1, "1040601", 21);
        Kata kata1040602 = new Kata(223, 104, 6, 2, "1040602", 22);
        Kata kata1040603 = new Kata(224, 104, 6, 3, "1040603", 23);
        Kata kata1040701 = new Kata(225, 104, 7, 1, "1040701", 24);
        Kata kata1040702 = new Kata(226, 104, 7, 2, "1040702", 25);
        Kata kata1040703 = new Kata(227, 104, 7, 3, "1040703", 26);
        Kata kata1040704 = new Kata(228, 104, 7, 4, "1040704", 27);
        Kata kata1040801 = new Kata(229, 104, 8, 1, "1040801", 28);
        Kata kata1040802 = new Kata(230, 104, 8, 2, "1040802", 29);
        Kata kata1040803 = new Kata(231, 104, 8, 3, "1040803", 30);
        Kata kata1040901 = new Kata(232, 104, 9, 1, "1040901", 31);
        Kata kata1040902 = new Kata(233, 104, 9, 2, "1040902", 32);
        Kata kata1040903 = new Kata(234, 104, 9, 3, "1040903", 33);

        // 103 - al-asr
        Kata kata1030101 = new Kata(235, 103, 1, 1, "1030101", 1);
        Kata kata1030201 = new Kata(236, 103, 2, 1, "1030201", 2);
        Kata kata1030202 = new Kata(237, 103, 2, 2, "1030202", 3);
        Kata kata1030203 = new Kata(238, 103, 2, 3, "1030203", 4);
        Kata kata1030204 = new Kata(239, 103, 2, 4, "1030204", 5);
        Kata kata1030205 = new Kata(240, 103, 2, 5, "1030205", 6);
        Kata kata1030206 = new Kata(241, 103, 2, 6, "1030206", 7);
        Kata kata1030207 = new Kata(242, 103, 2, 7, "1030207", 8);
        Kata kata1030208 = new Kata(243, 103, 2, 8, "1030208", 9);
        Kata kata1030209 = new Kata(244, 103, 2, 9, "1030209", 10);
        Kata kata1030301 = new Kata(245, 103, 3, 1, "1030301", 11);
        Kata kata1030302 = new Kata(246, 103, 3, 2, "1030302", 12);
        Kata kata1030303 = new Kata(247, 103, 3, 3, "1030303", 13);
        Kata kata1030304 = new Kata(248, 103, 3, 4, "1030304", 14);

        // 102 - al-atakasur
        Kata kata1020101 = new Kata(249, 102, 1, 1, "1020101", 1);
        Kata kata1020102 = new Kata(250, 102, 1, 2, "1020102", 2);
        Kata kata1020201 = new Kata(251, 102, 2, 1, "1020201", 3);
        Kata kata1020202 = new Kata(252, 102, 2, 2, "1020202", 4);
        Kata kata1020203 = new Kata(253, 102, 2, 3, "1020203", 5);
        Kata kata1020301 = new Kata(254, 102, 3, 1, "1020301", 6);
        Kata kata1020302 = new Kata(256, 102, 3, 2, "1020302", 7);
        Kata kata1020303 = new Kata(257, 102, 3, 3, "1020303", 8);
        Kata kata1020401 = new Kata(258, 102, 4, 1, "1020401", 9);
        Kata kata1020402 = new Kata(259, 102, 4, 2, "1020402", 10);
        Kata kata1020403 = new Kata(260, 102, 4, 3, "1020403", 11);
        Kata kata1020404 = new Kata(261, 102, 4, 4, "1020404", 12);
        Kata kata1020501 = new Kata(262, 102, 5, 1, "1020501", 13);
        Kata kata1020502 = new Kata(263, 102, 5, 2, "1020502", 14);
        Kata kata1020503 = new Kata(264, 102, 5, 3, "1020503", 15);
        Kata kata1020504 = new Kata(265, 102, 5, 4, "1020504", 16);
        Kata kata1020505 = new Kata(267, 102, 5, 5, "1020505", 17);
        Kata kata1020601 = new Kata(268, 102, 6, 1, "1020601", 18);
        Kata kata1020602 = new Kata(269, 102, 6, 2, "1020602", 19);
        Kata kata1020701 = new Kata(270, 102, 7, 1, "1020701", 20);
        Kata kata1020702 = new Kata(271, 102, 7, 2, "1020702", 21);
        Kata kata1020703 = new Kata(272, 102, 7, 3, "1020703", 22);
        Kata kata1020704 = new Kata(273, 102, 7, 4, "1020704", 23);
        Kata kata1020801 = new Kata(274, 102, 8, 1, "1020801", 24);
        Kata kata1020802 = new Kata(275, 102, 8, 2, "1020802", 25);
        Kata kata1020803 = new Kata(276, 102, 8, 3, "1020803", 26);
        Kata kata1020804 = new Kata(278, 102, 8, 4, "1020804", 27);
        Kata kata1020805 = new Kata(279, 102, 8, 5, "1020805", 28);

        //101 - al-qoriah
        Kata kata1010101 = new Kata(280, 101, 1, 1, "1010101", 1);
        Kata kata1010201 = new Kata(281, 101, 2, 1, "1010201", 2);
        Kata kata1010202 = new Kata(282, 101, 2, 2, "1050202", 3);
        Kata kata1010301 = new Kata(283, 101, 3, 1, "1010301", 4);
        Kata kata1010302 = new Kata(284, 101, 3, 2, "1010302", 5);
        Kata kata1010303 = new Kata(285, 101, 3, 3, "1010303", 6);
        Kata kata1010304 = new Kata(286, 101, 3, 4, "1010304", 7);
        Kata kata1010401 = new Kata(287, 101, 4, 1, "1010401", 8);
        Kata kata1010402 = new Kata(288, 101, 4, 2, "1010402", 9);
        Kata kata1010403 = new Kata(289, 101, 4, 3, "1010403", 10);
        Kata kata1010404 = new Kata(290, 101, 4, 4, "1010404", 11);
        Kata kata1010405 = new Kata(291, 101, 4, 5, "1010405", 12);
        Kata kata1010501 = new Kata(292, 101, 5, 1, "1010501", 13);
        Kata kata1010502 = new Kata(293, 101, 5, 2, "1010502", 14);
        Kata kata1010503 = new Kata(294, 101, 5, 3, "1010502", 15);
        Kata kata1010504 = new Kata(295, 101, 5, 4, "1010502", 16);
        Kata kata1010601 = new Kata(296, 101, 6, 1, "1010601", 17);
        Kata kata1010602 = new Kata(297, 101, 6, 2, "1010602", 18);
        Kata kata1010603 = new Kata(298, 101, 6, 3, "1010603", 19);
        Kata kata1010604 = new Kata(299, 101, 6, 4, "1010604", 20);
        Kata kata1010701 = new Kata(300, 101, 7, 1, "1010701", 21);
        Kata kata1010702 = new Kata(301, 101, 7, 2, "1010702", 22);
        Kata kata1010703 = new Kata(302, 101, 7, 3, "1010703", 23);
        Kata kata1010704 = new Kata(303, 101, 7, 4, "1010704", 24);
        Kata kata1010801 = new Kata(304, 101, 8, 1, "1010801", 25);
        Kata kata1010802 = new Kata(305, 101, 8, 2, "1010802", 26);
        Kata kata1010803 = new Kata(306, 101, 8, 3, "1010803", 27);
        Kata kata1010804 = new Kata(307, 101, 8, 4, "1010804", 28);
        Kata kata1010901 = new Kata(308, 101, 9, 1, "1010901", 29);
        Kata kata1010902 = new Kata(309, 101, 9, 2, "1010902", 30);
        Kata kata10101001 = new Kata(310, 101, 10, 1, "10101001", 31);
        Kata kata10101002 = new Kata(311, 101, 10, 2, "10101002", 32);
        Kata kata10101003 = new Kata(312, 101, 10, 3, "10101003", 33);
        Kata kata10101004 = new Kata(313, 101, 10, 4, "10101004", 34);
        Kata kata10101101 = new Kata(314, 101, 11, 1, "10101101", 35);
        Kata kata10101102 = new Kata(315, 101, 11, 2, "10101102", 36);

        //100 - al-adiyat
        Kata kata1000101 = new Kata(316, 100, 1, 1, "1000101", 1);
        Kata kata1000102 = new Kata(317, 100, 1, 2, "1000102", 2);
        Kata kata1000201 = new Kata(318, 100, 2, 1, "1000201", 3);
        Kata kata1000202 = new Kata(319, 100, 2, 2, "1000202", 4);
        Kata kata1000301 = new Kata(320, 100, 3, 1, "1000301", 5);
        Kata kata1000302 = new Kata(321, 100, 3, 2, "1000302", 6);
        Kata kata1000401 = new Kata(322, 100, 4, 1, "1000401", 7);
        Kata kata1000402 = new Kata(323, 100, 4, 2, "1000402", 8);
        Kata kata1000403 = new Kata(324, 100, 4, 3, "1000403", 9);
        Kata kata1000501 = new Kata(325, 100, 5, 1, "1000501", 10);
        Kata kata1000502 = new Kata(326, 100, 5, 2, "1000502", 11);
        Kata kata1000503 = new Kata(327, 100, 5, 3, "1000503", 12);
        Kata kata1000601 = new Kata(328, 100, 6, 1, "1000601", 13);
        Kata kata1000602 = new Kata(329, 100, 6, 2, "1000602", 14);
        Kata kata1000603 = new Kata(330, 100, 6, 3, "1000603", 15);
        Kata kata1000604 = new Kata(331, 100, 6, 4, "1000604", 16);
        Kata kata1000701 = new Kata(332, 100, 7, 1, "1000701", 17);
        Kata kata1000702 = new Kata(333, 100, 7, 2, "1000702", 18);
        Kata kata1000703 = new Kata(334, 100, 7, 3, "1000703", 19);
        Kata kata1000704 = new Kata(335, 100, 7, 4, "1000704", 20);
        Kata kata1000801 = new Kata(336, 100, 8, 1, "1000802", 21);
        Kata kata1000802 = new Kata(337, 100, 8, 2, "1000802", 22);
        Kata kata1000803 = new Kata(338, 100, 8, 3, "1000802", 23);
        Kata kata1000804 = new Kata(339, 100, 8, 4, "1000802", 24);
        Kata kata1000901 = new Kata(340, 100, 9, 1, "1000902", 25);
        Kata kata1000902 = new Kata(341, 100, 9, 2, "1000902", 26);
        Kata kata1000903 = new Kata(342, 100, 9, 3, "1000902", 27);
        Kata kata1000904 = new Kata(343, 100, 9, 4, "1000902", 28);
        Kata kata1000905 = new Kata(344, 100, 9, 5, "1000902", 29);
        Kata kata1000906 = new Kata(345, 100, 9, 6, "1000902", 30);
        Kata kata1000907 = new Kata(346, 100, 9, 7, "1000902", 31);
        Kata kata10001001 = new Kata(347, 100, 10, 1, "10001001", 32);
        Kata kata10001002 = new Kata(348, 100, 10, 2, "10001002", 33);
        Kata kata10001003 = new Kata(349, 100, 10, 3, "10001003", 34);
        Kata kata10001004 = new Kata(350, 100, 10, 4, "10001004", 35);
        Kata kata10001101 = new Kata(351, 100, 11, 1, "10001101", 36);
        Kata kata10001102 = new Kata(352, 100, 11, 2, "10001102", 37);
        Kata kata10001103 = new Kata(353, 100, 11, 3, "10001113", 38);
        Kata kata10001104 = new Kata(354, 100, 11, 4, "10001104", 39);
        Kata kata10001105 = new Kata(355, 100, 11, 5, "10001105", 40);

        // Inserting Kata in db
        // 114
        long kata1140101_id = db.createKata(kata1140101);
        long kata1140102_id = db.createKata(kata1140102);
        long kata1140103_id = db.createKata(kata1140103);
        long kata1140104_id = db.createKata(kata1140104);
        long kata1140201_id = db.createKata(kata1140201);
        long kata1140202_id = db.createKata(kata1140202);
        long kata1140301_id = db.createKata(kata1140301);
        long kata1140302_id = db.createKata(kata1140302);
        long kata1140401_id = db.createKata(kata1140401);
        long kata1140402_id = db.createKata(kata1140402);
        long kata1140403_id = db.createKata(kata1140403);
        long kata1140404_id = db.createKata(kata1140404);
        long kata1140501_id = db.createKata(kata1140501);
        long kata1140502_id = db.createKata(kata1140502);
        long kata1140503_id = db.createKata(kata1140503);
        long kata1140504_id = db.createKata(kata1140504);
        long kata1140505_id = db.createKata(kata1140505);
        long kata1140601_id = db.createKata(kata1140601);
        long kata1140602_id = db.createKata(kata1140602);
        long kata1140603_id = db.createKata(kata1140603);

        // 113
        long kata1130101_id = db.createKata(kata1130101);
        long kata1130102_id = db.createKata(kata1130102);
        long kata1130103_id = db.createKata(kata1130103);
        long kata1130104_id = db.createKata(kata1130104);
        long kata1130201_id = db.createKata(kata1130201);
        long kata1130202_id = db.createKata(kata1130202);
        long kata1130203_id = db.createKata(kata1130203);
        long kata1130204_id = db.createKata(kata1130204);
        long kata1130301_id = db.createKata(kata1130301);
        long kata1130302_id = db.createKata(kata1130302);
        long kata1130303_id = db.createKata(kata1130303);
        long kata1130304_id = db.createKata(kata1130304);
        long kata1130305_id = db.createKata(kata1130305);
        long kata1130401_id = db.createKata(kata1130401);
        long kata1130402_id = db.createKata(kata1130402);
        long kata1130403_id = db.createKata(kata1130403);
        long kata1130404_id = db.createKata(kata1130404);
        long kata1130405_id = db.createKata(kata1130405);
        long kata1130501_id = db.createKata(kata1130501);
        long kata1130502_id = db.createKata(kata1130502);
        long kata1130503_id = db.createKata(kata1130503);
        long kata1130504_id = db.createKata(kata1130504);
        long kata1130505_id = db.createKata(kata1130505);

        // 112
        long kata1120101_id = db.createKata(kata1120101);
        long kata1120102_id = db.createKata(kata1120102);
        long kata1120103_id = db.createKata(kata1120103);
        long kata1120104_id = db.createKata(kata1120104);
        long kata1120201_id = db.createKata(kata1120201);
        long kata1120202_id = db.createKata(kata1120202);
        long kata1120301_id = db.createKata(kata1120301);
        long kata1120302_id = db.createKata(kata1120302);
        long kata1120303_id = db.createKata(kata1120303);
        long kata1120304_id = db.createKata(kata1120304);
        long kata1120401_id = db.createKata(kata1120401);
        long kata1120402_id = db.createKata(kata1120402);
        long kata1120403_id = db.createKata(kata1120403);
        long kata1120404_id = db.createKata(kata1120404);
        long kata1120405_id = db.createKata(kata1120405);

        // 111
        long kata1110101_id = db.createKata(kata1110101);
        long kata1110102_id = db.createKata(kata1110102);
        long kata1110103_id = db.createKata(kata1110103);
        long kata1110104_id = db.createKata(kata1110104);
        long kata1110105_id = db.createKata(kata1110105);
        long kata1110201_id = db.createKata(kata1110201);
        long kata1110202_id = db.createKata(kata1110202);
        long kata1110203_id = db.createKata(kata1110203);
        long kata1110204_id = db.createKata(kata1110204);
        long kata1110205_id = db.createKata(kata1110205);
        long kata1110206_id = db.createKata(kata1110206);
        long kata1110301_id = db.createKata(kata1110301);
        long kata1110302_id = db.createKata(kata1110302);
        long kata1110303_id = db.createKata(kata1110303);
        long kata1110304_id = db.createKata(kata1110304);
        long kata1110401_id = db.createKata(kata1110401);
        long kata1110402_id = db.createKata(kata1110402);
        long kata1110403_id = db.createKata(kata1110403);
        long kata1110501_id = db.createKata(kata1110501);
        long kata1110502_id = db.createKata(kata1110502);
        long kata1110503_id = db.createKata(kata1110503);
        long kata1110504_id = db.createKata(kata1110504);
        long kata1110505_id = db.createKata(kata1110505);

        // 110
        long kata1100101_id = db.createKata(kata1100101);
        long kata1100102_id = db.createKata(kata1100102);
        long kata1100103_id = db.createKata(kata1100103);
        long kata1100104_id = db.createKata(kata1100104);
        long kata1100105_id = db.createKata(kata1100105);
        long kata1100201_id = db.createKata(kata1100201);
        long kata1100202_id = db.createKata(kata1100202);
        long kata1100203_id = db.createKata(kata1100203);
        long kata1100204_id = db.createKata(kata1100204);
        long kata1100205_id = db.createKata(kata1100205);
        long kata1100206_id = db.createKata(kata1100206);
        long kata1100207_id = db.createKata(kata1100207);
        long kata1100301_id = db.createKata(kata1100301);
        long kata1100302_id = db.createKata(kata1100302);
        long kata1100303_id = db.createKata(kata1100303);
        long kata1100304_id = db.createKata(kata1100304);
        long kata1100305_id = db.createKata(kata1100305);
        long kata1100306_id = db.createKata(kata1100306);
        long kata1100307_id = db.createKata(kata1100307);

        // 109
        long kata1090101_id = db.createKata(kata1090101);
        long kata1090102_id = db.createKata(kata1090102);
        long kata1090103_id = db.createKata(kata1090103);
        long kata1090201_id = db.createKata(kata1090201);
        long kata1090202_id = db.createKata(kata1090202);
        long kata1090203_id = db.createKata(kata1090203);
        long kata1090204_id = db.createKata(kata1090204);
        long kata1090301_id = db.createKata(kata1090301);
        long kata1090302_id = db.createKata(kata1090302);
        long kata1090303_id = db.createKata(kata1090303);
        long kata1090304_id = db.createKata(kata1090304);
        long kata1090305_id = db.createKata(kata1090305);
        long kata1090401_id = db.createKata(kata1090401);
        long kata1090402_id = db.createKata(kata1090402);
        long kata1090403_id = db.createKata(kata1090403);
        long kata1090404_id = db.createKata(kata1090404);
        long kata1090405_id = db.createKata(kata1090405);
        long kata1090501_id = db.createKata(kata1090501);
        long kata1090502_id = db.createKata(kata1090502);
        long kata1090503_id = db.createKata(kata1090503);
        long kata1090504_id = db.createKata(kata1090504);
        long kata1090505_id = db.createKata(kata1090505);
        long kata1090601_id = db.createKata(kata1090601);
        long kata1090602_id = db.createKata(kata1090602);
        long kata1090603_id = db.createKata(kata1090603);
        long kata1090604_id = db.createKata(kata1090604);

        // 108
        long kata1080101_id = db.createKata(kata1080101);
        long kata1080102_id = db.createKata(kata1080102);
        long kata1080103_id = db.createKata(kata1080103);
        long kata1080201_id = db.createKata(kata1080201);
        long kata1080202_id = db.createKata(kata1080202);
        long kata1080203_id = db.createKata(kata1080203);
        long kata1080301_id = db.createKata(kata1080301);
        long kata1080302_id = db.createKata(kata1080302);
        long kata1080303_id = db.createKata(kata1080303);
        long kata1080304_id = db.createKata(kata1080304);

        // 107
        long kata1070101_id = db.createKata(kata1070101);
        long kata1070102_id = db.createKata(kata1070102);
        long kata1070103_id = db.createKata(kata1070103);
        long kata1070104_id = db.createKata(kata1070104);
        long kata1070201_id = db.createKata(kata1070201);
        long kata1070202_id = db.createKata(kata1070202);
        long kata1070203_id = db.createKata(kata1070203);
        long kata1070204_id = db.createKata(kata1070204);
        long kata1070301_id = db.createKata(kata1070301);
        long kata1070302_id = db.createKata(kata1070302);
        long kata1070303_id = db.createKata(kata1070303);
        long kata1070304_id = db.createKata(kata1070304);
        long kata1070305_id = db.createKata(kata1070305);
        long kata1070401_id = db.createKata(kata1070401);
        long kata1070402_id = db.createKata(kata1070402);
        long kata1070501_id = db.createKata(kata1070501);
        long kata1070502_id = db.createKata(kata1070502);
        long kata1070503_id = db.createKata(kata1070503);
        long kata1070504_id = db.createKata(kata1070504);
        long kata1070505_id = db.createKata(kata1070505);
        long kata1070601_id = db.createKata(kata1070601);
        long kata1070602_id = db.createKata(kata1070602);
        long kata1070603_id = db.createKata(kata1070603);
        long kata1070701_id = db.createKata(kata1070701);
        long kata1070702_id = db.createKata(kata1070702);

        // 106
        long kata1060101_id = db.createKata(kata1060101);
        long kata1060102_id = db.createKata(kata1060102);
        long kata1060201_id = db.createKata(kata1060201);
        long kata1060202_id = db.createKata(kata1060202);
        long kata1060203_id = db.createKata(kata1060203);
        long kata1060204_id = db.createKata(kata1060204);
        long kata1060301_id = db.createKata(kata1060301);
        long kata1060302_id = db.createKata(kata1060302);
        long kata1060303_id = db.createKata(kata1060303);
        long kata1060304_id = db.createKata(kata1060304);
        long kata1060401_id = db.createKata(kata1060401);
        long kata1060402_id = db.createKata(kata1060402);
        long kata1060403_id = db.createKata(kata1060403);
        long kata1060404_id = db.createKata(kata1060404);
        long kata1060405_id = db.createKata(kata1060405);
        long kata1060406_id = db.createKata(kata1060406);
        long kata1060407_id = db.createKata(kata1060407);

        // 105
        long kata1050101_id = db.createKata(kata1050101);
        long kata1050102_id = db.createKata(kata1050102);
        long kata1050103_id = db.createKata(kata1050103);
        long kata1050104_id = db.createKata(kata1050104);
        long kata1050105_id = db.createKata(kata1050105);
        long kata1050106_id = db.createKata(kata1050106);
        long kata1050107_id = db.createKata(kata1050107);
        long kata1050201_id = db.createKata(kata1050201);
        long kata1050202_id = db.createKata(kata1050202);
        long kata1050203_id = db.createKata(kata1050203);
        long kata1050204_id = db.createKata(kata1050204);
        long kata1050205_id = db.createKata(kata1050205);
        long kata1050301_id = db.createKata(kata1050301);
        long kata1050302_id = db.createKata(kata1050302);
        long kata1050303_id = db.createKata(kata1050303);
        long kata1050304_id = db.createKata(kata1050304);
        long kata1050401_id = db.createKata(kata1050401);
        long kata1050402_id = db.createKata(kata1050402);
        long kata1050403_id = db.createKata(kata1050403);
        long kata1050404_id = db.createKata(kata1050404);
        long kata1050501_id = db.createKata(kata1050501);
        long kata1050502_id = db.createKata(kata1050502);
        long kata1050503_id = db.createKata(kata1050503);

        // 104
        long kata1040101_id = db.createKata(kata1040101);
        long kata1040102_id = db.createKata(kata1040102);
        long kata1040103_id = db.createKata(kata1040103);
        long kata1040104_id = db.createKata(kata1040104);
        long kata1040201_id = db.createKata(kata1040201);
        long kata1040202_id = db.createKata(kata1040202);
        long kata1040203_id = db.createKata(kata1040203);
        long kata1040204_id = db.createKata(kata1040204);
        long kata1040301_id = db.createKata(kata1040301);
        long kata1040302_id = db.createKata(kata1040302);
        long kata1040303_id = db.createKata(kata1040303);
        long kata1040304_id = db.createKata(kata1040304);
        long kata1040401_id = db.createKata(kata1040401);
        long kata1040402_id = db.createKata(kata1040402);
        long kata1040403_id = db.createKata(kata1040403);
        long kata1040404_id = db.createKata(kata1040404);
        long kata1040501_id = db.createKata(kata1040501);
        long kata1040502_id = db.createKata(kata1040502);
        long kata1040503_id = db.createKata(kata1040503);
        long kata1040504_id = db.createKata(kata1040504);
        long kata1040601_id = db.createKata(kata1040601);
        long kata1040602_id = db.createKata(kata1040602);
        long kata1040603_id = db.createKata(kata1040603);
        long kata1040701_id = db.createKata(kata1040701);
        long kata1040702_id = db.createKata(kata1040702);
        long kata1040703_id = db.createKata(kata1040703);
        long kata1040704_id = db.createKata(kata1040704);
        long kata1040801_id = db.createKata(kata1040801);
        long kata1040802_id = db.createKata(kata1040802);
        long kata1040803_id = db.createKata(kata1040803);
        long kata1040901_id = db.createKata(kata1040901);
        long kata1040902_id = db.createKata(kata1040902);
        long kata1040903_id = db.createKata(kata1040903);

        // 103
        long kata1030101_id = db.createKata(kata1030101);
        long kata1030201_id = db.createKata(kata1030201);
        long kata1030202_id = db.createKata(kata1030202);
        long kata1030203_id = db.createKata(kata1030203);
        long kata1030204_id = db.createKata(kata1030204);
        long kata1030301_id = db.createKata(kata1030205);
        long kata1030302_id = db.createKata(kata1030206);
        long kata1030303_id = db.createKata(kata1030207);
        long kata1030304_id = db.createKata(kata1030208);
        long kata1030305_id = db.createKata(kata1030209);
        long kata1030306_id = db.createKata(kata1030301);
        long kata1030307_id = db.createKata(kata1030302);
        long kata1030308_id = db.createKata(kata1030303);
        long kata1030309_id = db.createKata(kata1030304);

        // 102
        long kata1020101_id = db.createKata(kata1020101);
        long kata1020102_id = db.createKata(kata1020102);
        long kata1020201_id = db.createKata(kata1020201);
        long kata1020202_id = db.createKata(kata1020202);
        long kata1020203_id = db.createKata(kata1020203);
        long kata1020301_id = db.createKata(kata1020301);
        long kata1020302_id = db.createKata(kata1020302);
        long kata1020303_id = db.createKata(kata1020303);
        long kata1020401_id = db.createKata(kata1020401);
        long kata1020402_id = db.createKata(kata1020402);
        long kata1020403_id = db.createKata(kata1020403);
        long kata1020404_id = db.createKata(kata1020404);
        long kata1020501_id = db.createKata(kata1020501);
        long kata1020502_id = db.createKata(kata1020502);
        long kata1020503_id = db.createKata(kata1020503);
        long kata1020504_id = db.createKata(kata1020504);
        long kata1020505_id = db.createKata(kata1020505);
        long kata1020601_id = db.createKata(kata1020601);
        long kata1020602_id = db.createKata(kata1020602);
        long kata1020701_id = db.createKata(kata1020701);
        long kata1020702_id = db.createKata(kata1020702);
        long kata1020703_id = db.createKata(kata1020703);
        long kata1020704_id = db.createKata(kata1020704);
        long kata1020801_id = db.createKata(kata1020801);
        long kata1020802_id = db.createKata(kata1020802);
        long kata1020803_id = db.createKata(kata1020803);
        long kata1020804_id = db.createKata(kata1020804);
        long kata1020805_id = db.createKata(kata1020805);

        // 101
        long kata1010101_id = db.createKata(kata1010101);
        long kata1010201_id = db.createKata(kata1010201);
        long kata1010202_id = db.createKata(kata1010202);
        long kata1010301_id = db.createKata(kata1010301);
        long kata1010302_id = db.createKata(kata1010302);
        long kata1010303_id = db.createKata(kata1010303);
        long kata1010304_id = db.createKata(kata1010304);
        long kata1010401_id = db.createKata(kata1010401);
        long kata1010402_id = db.createKata(kata1010402);
        long kata1010403_id = db.createKata(kata1010403);
        long kata1010404_id = db.createKata(kata1010404);
        long kata1010405_id = db.createKata(kata1010405);
        long kata1010501_id = db.createKata(kata1010501);
        long kata1010502_id = db.createKata(kata1010502);
        long kata1010503_id = db.createKata(kata1010503);
        long kata1010504_id = db.createKata(kata1010504);
        long kata1010601_id = db.createKata(kata1010601);
        long kata1010602_id = db.createKata(kata1010602);
        long kata1010603_id = db.createKata(kata1010603);
        long kata1010604_id = db.createKata(kata1010604);
        long kata1010701_id = db.createKata(kata1010701);
        long kata1010702_id = db.createKata(kata1010702);
        long kata1010703_id = db.createKata(kata1010703);
        long kata1010704_id = db.createKata(kata1010704);
        long kata1010801_id = db.createKata(kata1010801);
        long kata1010802_id = db.createKata(kata1010802);
        long kata1010803_id = db.createKata(kata1010803);
        long kata1010804_id = db.createKata(kata1010804);
        long kata1010901_id = db.createKata(kata1010901);
        long kata1010902_id = db.createKata(kata1010902);
        long kata10101001_id = db.createKata(kata10101001);
        long kata10101002_id = db.createKata(kata10101002);
        long kata10101003_id = db.createKata(kata10101003);
        long kata10101004_id = db.createKata(kata10101004);
        long kata10101101_id = db.createKata(kata10101101);
        long kata10101102_id = db.createKata(kata10101102);

        // 100
        long kata1000101_id = db.createKata(kata1000101);
        long kata1000102_id = db.createKata(kata1000102);
        long kata1000201_id = db.createKata(kata1000201);
        long kata1000202_id = db.createKata(kata1000202);
        long kata1000301_id = db.createKata(kata1000301);
        long kata1000302_id = db.createKata(kata1000302);
        long kata1000401_id = db.createKata(kata1000401);
        long kata1000402_id = db.createKata(kata1000402);
        long kata1000403_id = db.createKata(kata1000403);
        long kata1000501_id = db.createKata(kata1000501);
        long kata1000502_id = db.createKata(kata1000502);
        long kata1000503_id = db.createKata(kata1000503);
        long kata1000601_id = db.createKata(kata1000601);
        long kata1000602_id = db.createKata(kata1000602);
        long kata1000603_id = db.createKata(kata1000603);
        long kata1000604_id = db.createKata(kata1000604);
        long kata1000701_id = db.createKata(kata1000701);
        long kata1000702_id = db.createKata(kata1000702);
        long kata1000703_id = db.createKata(kata1000703);
        long kata1000704_id = db.createKata(kata1000704);
        long kata1000801_id = db.createKata(kata1000801);
        long kata1000802_id = db.createKata(kata1000802);
        long kata1000803_id = db.createKata(kata1000803);
        long kata1000804_id = db.createKata(kata1000804);
        long kata1000901_id = db.createKata(kata1000901);
        long kata1000902_id = db.createKata(kata1000902);
        long kata1000903_id = db.createKata(kata1000903);
        long kata1000904_id = db.createKata(kata1000904);
        long kata1000905_id = db.createKata(kata1000905);
        long kata1000906_id = db.createKata(kata1000906);
        long kata1000907_id = db.createKata(kata1000907);
        long kata10001001_id = db.createKata(kata10001001);
        long kata10001002_id = db.createKata(kata10001002);
        long kata10001003_id = db.createKata(kata10001003);
        long kata10001004_id = db.createKata(kata10001004);
        long kata10001101_id = db.createKata(kata10001101);
        long kata10001102_id = db.createKata(kata10001102);
        long kata10001103_id = db.createKata(kata10001103);
        long kata10001104_id = db.createKata(kata10001104);
        long kata10001105_id = db.createKata(kata10001105);


        Log.d("Kata Count", "Kata Count: " + db.getAllKata().size());

        // Creating Blok Kosong
        BlokKosong blokkosong1141 = new BlokKosong(1, 114, 1, 5);
        BlokKosong blokkosong1142 = new BlokKosong(2, 114, 2, 10);
        BlokKosong blokkosong1143 = new BlokKosong(3, 114, 3, 15);
        BlokKosong blokkosong1131 = new BlokKosong(4, 113, 1, 6);
        BlokKosong blokkosong1132 = new BlokKosong(5, 113, 2, 12);
        BlokKosong blokkosong1133 = new BlokKosong(6, 113, 3, 17);
        BlokKosong blokkosong1121 = new BlokKosong(7, 112, 1, 4);
        BlokKosong blokkosong1122 = new BlokKosong(8, 112, 2, 8);
        BlokKosong blokkosong1123 = new BlokKosong(9, 112, 3, 11);
        BlokKosong blokkosong1111 = new BlokKosong(10, 111, 1, 6);
        BlokKosong blokkosong1112 = new BlokKosong(11, 111, 2, 12);
        BlokKosong blokkosong1113 = new BlokKosong(12, 111, 3, 17);
        BlokKosong blokkosong1101 = new BlokKosong(13, 110, 1, 5);
        BlokKosong blokkosong1102 = new BlokKosong(14, 110, 2, 10);
        BlokKosong blokkosong1103 = new BlokKosong(15, 110, 3, 14);
        BlokKosong blokkosong1091 = new BlokKosong(16, 109, 1, 7);
        BlokKosong blokkosong1092 = new BlokKosong(17, 109, 2, 13);
        BlokKosong blokkosong1093 = new BlokKosong(18, 109, 3, 20);
        BlokKosong blokkosong1081 = new BlokKosong(19, 108, 1, 3);
        BlokKosong blokkosong1082 = new BlokKosong(20, 108, 2, 5);
        BlokKosong blokkosong1083 = new BlokKosong(21, 108, 3, 8);
        BlokKosong blokkosong1071 = new BlokKosong(22, 107, 1, 6);
        BlokKosong blokkosong1072 = new BlokKosong(23, 107, 2, 13);
        BlokKosong blokkosong1073 = new BlokKosong(24, 107, 3, 19);
        BlokKosong blokkosong1061 = new BlokKosong(25, 106, 1, 4);
        BlokKosong blokkosong1062 = new BlokKosong(26, 106, 2, 9);
        BlokKosong blokkosong1063 = new BlokKosong(27, 106, 3, 13);
        BlokKosong blokkosong1051 = new BlokKosong(28, 105, 1, 6);
        BlokKosong blokkosong1052 = new BlokKosong(29, 105, 2, 12);
        BlokKosong blokkosong1053 = new BlokKosong(30, 105, 3, 11);
        BlokKosong blokkosong1041 = new BlokKosong(31, 104, 1, 5);
        BlokKosong blokkosong1042 = new BlokKosong(32, 104, 2, 10);
        BlokKosong blokkosong1043 = new BlokKosong(33, 104, 3, 15);
        BlokKosong blokkosong1031 = new BlokKosong(34, 103, 1, 9);
        BlokKosong blokkosong1032 = new BlokKosong(35, 103, 2, 11);
        BlokKosong blokkosong1033 = new BlokKosong(36, 103, 3, 10);
        BlokKosong blokkosong1021 = new BlokKosong(37, 102, 1, 5);
        BlokKosong blokkosong1022 = new BlokKosong(38, 102, 2, 10);
        BlokKosong blokkosong1023 = new BlokKosong(39, 102, 3, 15);
        BlokKosong blokkosong1011 = new BlokKosong(40, 101, 1, 5);
        BlokKosong blokkosong1012 = new BlokKosong(41, 101, 2, 10);
        BlokKosong blokkosong1013 = new BlokKosong(42, 101, 3, 15);
        BlokKosong blokkosong1010 = new BlokKosong(43, 100, 1, 5);
        BlokKosong blokkosong1009 = new BlokKosong(44, 100, 2, 10);
        BlokKosong blokkosong1008 = new BlokKosong(45, 100, 3, 15);

        // Inserting Blok Kosong in db
        long blokkosong1141_id = db.createBlokKosong(blokkosong1141);
        long blokkosong1142_id = db.createBlokKosong(blokkosong1142);
        long blokkosong1143_id = db.createBlokKosong(blokkosong1143);
        long blokkosong1131_id = db.createBlokKosong(blokkosong1131);
        long blokkosong1132_id = db.createBlokKosong(blokkosong1132);
        long blokkosong1133_id = db.createBlokKosong(blokkosong1133);
        long blokkosong1121_id = db.createBlokKosong(blokkosong1121);
        long blokkosong1122_id = db.createBlokKosong(blokkosong1122);
        long blokkosong1123_id = db.createBlokKosong(blokkosong1123);
        long blokkosong1111_id = db.createBlokKosong(blokkosong1111);
        long blokkosong1112_id = db.createBlokKosong(blokkosong1112);
        long blokkosong1113_id = db.createBlokKosong(blokkosong1113);
        long blokkosong1101_id = db.createBlokKosong(blokkosong1101);
        long blokkosong1102_id = db.createBlokKosong(blokkosong1102);
        long blokkosong1103_id = db.createBlokKosong(blokkosong1103);
        long blokkosong1091_id = db.createBlokKosong(blokkosong1091);
        long blokkosong1092_id = db.createBlokKosong(blokkosong1092);
        long blokkosong1093_id = db.createBlokKosong(blokkosong1093);
        long blokkosong1081_id = db.createBlokKosong(blokkosong1081);
        long blokkosong1082_id = db.createBlokKosong(blokkosong1082);
        long blokkosong1083_id = db.createBlokKosong(blokkosong1083);
        long blokkosong1071_id = db.createBlokKosong(blokkosong1071);
        long blokkosong1072_id = db.createBlokKosong(blokkosong1072);
        long blokkosong1073_id = db.createBlokKosong(blokkosong1073);
        long blokkosong1061_id = db.createBlokKosong(blokkosong1061);
        long blokkosong1062_id = db.createBlokKosong(blokkosong1062);
        long blokkosong1063_id = db.createBlokKosong(blokkosong1063);
        long blokkosong1051_id = db.createBlokKosong(blokkosong1051);
        long blokkosong1052_id = db.createBlokKosong(blokkosong1052);
        long blokkosong1053_id = db.createBlokKosong(blokkosong1053);
        long blokkosong1041_id = db.createBlokKosong(blokkosong1041);
        long blokkosong1042_id = db.createBlokKosong(blokkosong1042);
        long blokkosong1043_id = db.createBlokKosong(blokkosong1043);
        long blokkosong1031_id = db.createBlokKosong(blokkosong1031);
        long blokkosong1032_id = db.createBlokKosong(blokkosong1032);
        long blokkosong1033_id = db.createBlokKosong(blokkosong1033);
        long blokkosong1021_id = db.createBlokKosong(blokkosong1021);
        long blokkosong1022_id = db.createBlokKosong(blokkosong1022);
        long blokkosong1023_id = db.createBlokKosong(blokkosong1023);
        long blokkosong1011_id = db.createBlokKosong(blokkosong1011);
        long blokkosong1012_id = db.createBlokKosong(blokkosong1012);
        long blokkosong1013_id = db.createBlokKosong(blokkosong1013);
        long blokkosong1010_id = db.createBlokKosong(blokkosong1010);
        long blokkosong1009_id = db.createBlokKosong(blokkosong1009);
        long blokkosong1008_id = db.createBlokKosong(blokkosong1008);

        Log.d("Blok Kosong Count", "Blok Kosong Count: " + db.getAllBlokKosong().size());

        // Creating Settings
        Settings settings1 = new Settings("new", 1, "");
        Settings settings2 = new Settings("puzzle", 1, "");
        Settings settings3 = new Settings("surat", 114, "");
        Settings settings4 = new Settings("level", 1, "");
        Settings settings5 = new Settings("nilai", 0, "");
        Settings settings6 = new Settings("waktu", 0, "");
        Settings settings7 = new Settings("salah", 0, "");
        Settings settings8 = new Settings("bantuan", 0, "");
        Settings settings9 = new Settings("bonus", 0, "");
        Settings settings10 = new Settings("totalnilai", 0, "");
        Settings settings11 = new Settings("totalwaktu", 0, "");
        Settings settings12 = new Settings("nextpuzzle", 1, "");
        Settings settings13 = new Settings("nextsurat", 114, "");
        Settings settings14 = new Settings("nextlevel", 1, "");
        Settings settings15 = new Settings("namapemain", 0, "");

        // Inserting Settings in db
        long settings1_id = db.createSettings(settings1);
        long settings2_id = db.createSettings(settings2);
        long settings3_id = db.createSettings(settings3);
        long settings4_id = db.createSettings(settings4);
        long settings5_id = db.createSettings(settings5);
        long settings6_id = db.createSettings(settings6);
        long settings7_id = db.createSettings(settings7);
        long settings8_id = db.createSettings(settings8);
        long settings9_id = db.createSettings(settings9);
        long settings10_id = db.createSettings(settings10);
        long settings11_id = db.createSettings(settings11);
        long settings12_id = db.createSettings(settings12);
        long settings13_id = db.createSettings(settings13);
        long settings14_id = db.createSettings(settings14);
        long settings15_id = db.createSettings(settings15);

        Log.d("Settings Count", "Settings Count: " + db.getAllSettings().size());

        Intent intent = new Intent(SettingDBActivity.this, MenuUtamaActivity.class);
        startActivity(intent);

        finish();
    }
}
