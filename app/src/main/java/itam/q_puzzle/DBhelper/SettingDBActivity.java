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
 * Created by M. ROMADLONI on 18-06-2016.
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
        BlokKosong blokkosong1053 = new BlokKosong(30, 105, 3, 17);

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
