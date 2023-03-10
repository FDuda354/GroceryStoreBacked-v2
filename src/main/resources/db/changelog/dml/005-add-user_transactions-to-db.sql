--liquibase formatted sql
--changeset FDuda:13

INSERT INTO user_transactions(id, amount,description,wallet_id,direction)
VALUES
(1, 711, 'DAIRY', 9, 'INCOME'),
(2, 754, 'GRAINS', 4, 'OUTCOME'),
(3, 471, 'MEAT', 5, 'INCOME'),
(4, 461, 'GRAINS', 8, 'INCOME'),
(5, 691, 'MEAT', 13, 'OUTCOME'),
(6, 462, 'MEAT', 13, 'OUTCOME'),
(7, 161, 'VEGETABLES', 10, 'INCOME'),
(8, 579, 'VEGETABLES', 6, 'OUTCOME'),
(9, 567, 'FRUITS', 13, 'INCOME'),
(10, 273, 'GRAINS', 7, 'INCOME'),
(11, 833, 'VEGETABLES', 3, 'OUTCOME'),
(12, 505, 'MEAT', 3, 'OUTCOME'),
(13, 395, 'GRAINS', 4, 'OUTCOME'),
(14, 401, 'DAIRY', 7, 'INCOME'),
(15, 402, 'VEGETABLES', 9, 'OUTCOME'),
(16, 174, 'DAIRY', 5, 'INCOME'),
(17, 574, 'FRUITS', 13, 'OUTCOME'),
(18, 597, 'FRUITS', 4, 'INCOME'),
(19, 295, 'VEGETABLES', 7, 'OUTCOME'),
(20, 757, 'FRUITS', 11, 'OUTCOME'),
(21, 362, 'DAIRY', 11, 'OUTCOME'),
(22, 819, 'MEAT', 8, 'INCOME'),
(23, 975, 'MEAT', 8, 'OUTCOME'),
(24, 623, 'DAIRY', 3, 'INCOME'),
(25, 332, 'GRAINS', 1, 'OUTCOME'),
(26, 522, 'MEAT', 12, 'OUTCOME'),
(27, 270, 'VEGETABLES', 13, 'OUTCOME'),
(28, 585, 'VEGETABLES', 9, 'OUTCOME'),
(29, 898, 'DAIRY', 9, 'OUTCOME'),
(30, 853, 'FRUITS', 7, 'INCOME'),
(31, 182, 'VEGETABLES', 9, 'INCOME'),
(32, 89, 'MEAT', 11, 'INCOME'),
(33, 614, 'DAIRY', 4, 'INCOME'),
(34, 553, 'MEAT', 6, 'INCOME'),
(35, 514, 'FRUITS', 4, 'OUTCOME'),
(36, 992, 'MEAT', 1, 'INCOME'),
(37, 855, 'DAIRY', 3, 'OUTCOME'),
(38, 955, 'GRAINS', 3, 'INCOME'),
(39, 901, 'FRUITS', 10, 'INCOME'),
(40, 429, 'MEAT', 6, 'INCOME'),
(41, 990, 'GRAINS', 12, 'OUTCOME'),
(42, 976, 'GRAINS', 11, 'OUTCOME'),
(43, 860, 'GRAINS', 5, 'INCOME'),
(44, 739, 'DAIRY', 10, 'OUTCOME'),
(45, 215, 'MEAT', 3, 'OUTCOME'),
(46, 332, 'MEAT', 5, 'INCOME'),
(47, 592, 'VEGETABLES', 3, 'OUTCOME'),
(48, 617, 'DAIRY', 13, 'OUTCOME'),
(49, 707, 'FRUITS', 12, 'INCOME'),
(50, 820, 'MEAT', 9, 'INCOME'),
(51, 82, 'FRUITS', 5, 'INCOME'),
(52, 296, 'GRAINS', 6, 'INCOME'),
(53, 699, 'VEGETABLES', 3, 'OUTCOME'),
(54, 396, 'VEGETABLES', 4, 'OUTCOME'),
(55, 196, 'FRUITS', 2, 'OUTCOME'),
(56, 797, 'MEAT', 8, 'OUTCOME'),
(57, 630, 'MEAT', 8, 'OUTCOME'),
(58, 934, 'GRAINS', 6, 'OUTCOME'),
(59, 964, 'GRAINS', 10, 'OUTCOME'),
(60, 564, 'MEAT', 6, 'INCOME'),
(61, 61, 'GRAINS', 10, 'OUTCOME'),
(62, 136, 'MEAT', 5, 'OUTCOME'),
(63, 735, 'FRUITS', 4, 'OUTCOME'),
(64, 697, 'VEGETABLES', 7, 'INCOME'),
(65, 860, 'GRAINS', 6, 'INCOME'),
(66, 465, 'MEAT', 9, 'OUTCOME'),
(67, 531, 'VEGETABLES', 4, 'OUTCOME'),
(68, 499, 'VEGETABLES', 1, 'INCOME'),
(69, 493, 'MEAT', 5, 'INCOME'),
(70, 246, 'DAIRY', 9, 'INCOME'),
(71, 681, 'DAIRY', 2, 'OUTCOME'),
(72, 988, 'GRAINS', 1, 'OUTCOME'),
(73, 643, 'MEAT', 11, 'OUTCOME'),
(74, 674, 'VEGETABLES', 5, 'OUTCOME'),
(75, 468, 'FRUITS', 13, 'INCOME'),
(76, 58, 'FRUITS', 2, 'INCOME'),
(77, 381, 'VEGETABLES', 10, 'INCOME'),
(78, 230, 'FRUITS', 11, 'INCOME'),
(79, 774, 'DAIRY', 4, 'OUTCOME'),
(80, 273, 'MEAT', 12, 'OUTCOME'),
(81, 117, 'MEAT', 11, 'OUTCOME'),
(82, 784, 'MEAT', 5, 'INCOME'),
(83, 702, 'GRAINS', 9, 'OUTCOME'),
(84, 418, 'VEGETABLES', 13, 'INCOME'),
(85, 965, 'VEGETABLES', 8, 'OUTCOME'),
(86, 289, 'DAIRY', 5, 'INCOME'),
(87, 839, 'MEAT', 2, 'OUTCOME'),
(88, 512, 'VEGETABLES', 3, 'INCOME'),
(89, 209, 'DAIRY', 4, 'INCOME'),
(90, 295, 'VEGETABLES', 5, 'OUTCOME'),
(91, 864, 'VEGETABLES', 10, 'INCOME'),
(92, 204, 'FRUITS', 10, 'INCOME'),
(93, 672, 'FRUITS', 3, 'INCOME'),
(94, 396, 'MEAT', 10, 'OUTCOME'),
(95, 51, 'FRUITS', 2, 'INCOME'),
(96, 974, 'FRUITS', 1, 'OUTCOME'),
(97, 553, 'FRUITS', 1, 'INCOME'),
(98, 170, 'VEGETABLES', 7, 'OUTCOME'),
(99, 796, 'VEGETABLES', 11, 'OUTCOME'),
(100, 819, 'GRAINS', 8, 'INCOME'),
(101, 822, 'GRAINS', 7, 'INCOME'),
(102, 93, 'DAIRY', 10, 'OUTCOME'),
(103, 304, 'GRAINS', 6, 'OUTCOME'),
(104, 284, 'MEAT', 3, 'OUTCOME'),
(105, 932, 'FRUITS', 12, 'OUTCOME'),
(106, 846, 'VEGETABLES', 9, 'OUTCOME'),
(107, 450, 'DAIRY', 3, 'INCOME'),
(108, 227, 'GRAINS', 4, 'OUTCOME'),
(109, 535, 'FRUITS', 9, 'INCOME'),
(110, 187, 'GRAINS', 5, 'INCOME'),
(111, 68, 'MEAT', 13, 'OUTCOME'),
(112, 966, 'MEAT', 8, 'INCOME'),
(113, 695, 'VEGETABLES', 8, 'OUTCOME'),
(114, 342, 'MEAT', 7, 'INCOME'),
(115, 887, 'MEAT', 12, 'OUTCOME'),
(116, 81, 'VEGETABLES', 2, 'OUTCOME'),
(117, 271, 'VEGETABLES', 11, 'OUTCOME'),
(118, 58, 'DAIRY', 13, 'INCOME'),
(119, 366, 'DAIRY', 9, 'OUTCOME'),
(120, 219, 'MEAT', 1, 'INCOME'),
(121, 105, 'FRUITS', 8, 'INCOME'),
(122, 290, 'VEGETABLES', 2, 'OUTCOME'),
(123, 953, 'MEAT', 2, 'OUTCOME'),
(124, 991, 'VEGETABLES', 4, 'INCOME'),
(125, 309, 'GRAINS', 3, 'INCOME'),
(126, 890, 'DAIRY', 4, 'INCOME'),
(127, 260, 'MEAT', 11, 'OUTCOME'),
(128, 164, 'DAIRY', 3, 'OUTCOME'),
(129, 486, 'VEGETABLES', 8, 'OUTCOME'),
(130, 743, 'FRUITS', 9, 'OUTCOME'),
(131, 354, 'VEGETABLES', 4, 'OUTCOME'),
(132, 502, 'DAIRY', 5, 'INCOME'),
(133, 780, 'DAIRY', 1, 'OUTCOME'),
(134, 630, 'GRAINS', 8, 'OUTCOME'),
(135, 976, 'DAIRY', 6, 'OUTCOME'),
(136, 742, 'VEGETABLES', 2, 'INCOME'),
(137, 155, 'VEGETABLES', 8, 'OUTCOME'),
(138, 919, 'MEAT', 4, 'INCOME'),
(139, 480, 'FRUITS', 9, 'INCOME'),
(140, 605, 'MEAT', 12, 'OUTCOME'),
(141, 626, 'MEAT', 10, 'INCOME'),
(142, 384, 'VEGETABLES', 4, 'OUTCOME'),
(143, 733, 'DAIRY', 2, 'OUTCOME'),
(144, 766, 'FRUITS', 13, 'OUTCOME'),
(145, 57, 'FRUITS', 5, 'OUTCOME'),
(146, 305, 'GRAINS', 3, 'INCOME'),
(147, 810, 'MEAT', 3, 'INCOME'),
(148, 361, 'MEAT', 5, 'INCOME'),
(149, 64, 'DAIRY', 3, 'OUTCOME'),
(150, 637, 'GRAINS', 6, 'OUTCOME'),
(151, 569, 'GRAINS', 1, 'OUTCOME'),
(152, 293, 'DAIRY', 10, 'OUTCOME'),
(153, 421, 'GRAINS', 12, 'INCOME'),
(154, 930, 'MEAT', 11, 'INCOME'),
(155, 463, 'FRUITS', 2, 'OUTCOME'),
(156, 530, 'DAIRY', 6, 'OUTCOME'),
(157, 725, 'MEAT', 4, 'INCOME'),
(158, 75, 'FRUITS', 12, 'OUTCOME'),
(159, 199, 'GRAINS', 13, 'INCOME'),
(160, 94, 'GRAINS', 5, 'OUTCOME'),
(161, 245, 'VEGETABLES', 9, 'OUTCOME'),
(162, 827, 'VEGETABLES', 5, 'INCOME'),
(163, 644, 'DAIRY', 5, 'INCOME'),
(164, 423, 'VEGETABLES', 10, 'OUTCOME'),
(165, 955, 'VEGETABLES', 9, 'INCOME'),
(166, 977, 'FRUITS', 4, 'OUTCOME'),
(167, 112, 'VEGETABLES', 10, 'OUTCOME'),
(168, 868, 'GRAINS', 4, 'OUTCOME'),
(169, 341, 'FRUITS', 13, 'OUTCOME'),
(170, 920, 'MEAT', 2, 'INCOME'),
(171, 878, 'FRUITS', 1, 'OUTCOME'),
(172, 84, 'GRAINS', 13, 'INCOME'),
(173, 589, 'FRUITS', 8, 'INCOME'),
(174, 235, 'FRUITS', 11, 'OUTCOME'),
(175, 199, 'GRAINS', 6, 'INCOME'),
(176, 781, 'DAIRY', 3, 'OUTCOME'),
(177, 825, 'DAIRY', 3, 'INCOME'),
(178, 712, 'VEGETABLES', 9, 'INCOME'),
(179, 98, 'FRUITS', 9, 'INCOME'),
(180, 187, 'MEAT', 4, 'OUTCOME'),
(181, 235, 'VEGETABLES', 13, 'OUTCOME'),
(182, 115, 'DAIRY', 8, 'OUTCOME'),
(183, 367, 'DAIRY', 1, 'OUTCOME'),
(184, 521, 'DAIRY', 12, 'OUTCOME'),
(185, 624, 'DAIRY', 4, 'INCOME'),
(186, 240, 'VEGETABLES', 11, 'INCOME'),
(187, 158, 'GRAINS', 12, 'INCOME'),
(188, 765, 'GRAINS', 9, 'OUTCOME'),
(189, 559, 'FRUITS', 12, 'INCOME'),
(190, 135, 'DAIRY', 2, 'OUTCOME'),
(191, 235, 'MEAT', 12, 'OUTCOME'),
(192, 674, 'FRUITS', 13, 'INCOME'),
(193, 993, 'VEGETABLES', 10, 'OUTCOME'),
(194, 990, 'FRUITS', 9, 'OUTCOME'),
(195, 705, 'MEAT', 11, 'OUTCOME'),
(196, 505, 'VEGETABLES', 9, 'OUTCOME'),
(197, 849, 'VEGETABLES', 2, 'INCOME'),
(198, 640, 'GRAINS', 8, 'OUTCOME'),
(199, 153, 'MEAT', 5, 'OUTCOME'),
(200, 651, 'DAIRY', 6, 'INCOME'),
(201, 175, 'DAIRY', 1, 'INCOME'),
(202, 949, 'GRAINS', 13, 'OUTCOME'),
(203, 596, 'FRUITS', 3, 'INCOME'),
(204, 935, 'MEAT', 7, 'INCOME'),
(205, 168, 'VEGETABLES', 4, 'OUTCOME'),
(206, 253, 'VEGETABLES', 9, 'INCOME'),
(207, 910, 'FRUITS', 10, 'INCOME'),
(208, 88, 'VEGETABLES', 2, 'OUTCOME'),
(209, 396, 'VEGETABLES', 2, 'INCOME'),
(210, 112, 'VEGETABLES', 13, 'INCOME'),
(211, 319, 'FRUITS', 5, 'INCOME'),
(212, 995, 'GRAINS', 8, 'INCOME'),
(213, 354, 'DAIRY', 7, 'INCOME'),
(214, 893, 'DAIRY', 3, 'OUTCOME'),
(215, 257, 'VEGETABLES', 10, 'OUTCOME'),
(216, 831, 'FRUITS', 9, 'INCOME'),
(217, 387, 'DAIRY', 10, 'OUTCOME'),
(218, 446, 'VEGETABLES', 2, 'INCOME'),
(219, 416, 'DAIRY', 1, 'OUTCOME'),
(220, 254, 'VEGETABLES', 5, 'OUTCOME'),
(221, 957, 'VEGETABLES', 6, 'INCOME'),
(222, 351, 'GRAINS', 10, 'OUTCOME'),
(223, 319, 'DAIRY', 10, 'INCOME'),
(224, 413, 'MEAT', 2, 'INCOME'),
(225, 82, 'VEGETABLES', 4, 'INCOME'),
(226, 515, 'MEAT', 10, 'OUTCOME'),
(227, 384, 'FRUITS', 6, 'OUTCOME'),
(228, 352, 'VEGETABLES', 6, 'INCOME'),
(229, 337, 'MEAT', 5, 'OUTCOME'),
(230, 572, 'FRUITS', 12, 'INCOME'),
(231, 176, 'DAIRY', 7, 'INCOME'),
(232, 898, 'FRUITS', 7, 'OUTCOME'),
(233, 388, 'VEGETABLES', 9, 'INCOME'),
(234, 259, 'MEAT', 8, 'OUTCOME'),
(235, 910, 'VEGETABLES', 5, 'OUTCOME'),
(236, 598, 'DAIRY', 13, 'INCOME'),
(237, 940, 'FRUITS', 6, 'OUTCOME'),
(238, 642, 'VEGETABLES', 9, 'OUTCOME'),
(239, 181, 'MEAT', 2, 'INCOME'),
(240, 230, 'DAIRY', 12, 'OUTCOME'),
(241, 748, 'VEGETABLES', 3, 'OUTCOME'),
(242, 340, 'GRAINS', 11, 'OUTCOME'),
(243, 175, 'DAIRY', 2, 'OUTCOME'),
(244, 413, 'GRAINS', 10, 'INCOME'),
(245, 276, 'VEGETABLES', 5, 'INCOME'),
(246, 235, 'GRAINS', 1, 'OUTCOME'),
(247, 414, 'DAIRY', 10, 'OUTCOME'),
(248, 860, 'DAIRY', 10, 'INCOME'),
(249, 781, 'DAIRY', 7, 'OUTCOME'),
(250, 446, 'VEGETABLES', 11, 'OUTCOME'),
(251, 688, 'DAIRY', 12, 'OUTCOME'),
(252, 516, 'VEGETABLES', 7, 'OUTCOME'),
(253, 996, 'DAIRY', 6, 'OUTCOME'),
(254, 630, 'DAIRY', 6, 'INCOME'),
(255, 127, 'DAIRY', 3, 'OUTCOME'),
(256, 57, 'VEGETABLES', 6, 'INCOME'),
(257, 708, 'DAIRY', 12, 'INCOME'),
(258, 339, 'DAIRY', 10, 'OUTCOME'),
(259, 488, 'FRUITS', 12, 'OUTCOME'),
(260, 227, 'VEGETABLES', 12, 'OUTCOME'),
(261, 216, 'DAIRY', 6, 'INCOME'),
(262, 391, 'FRUITS', 8, 'OUTCOME'),
(263, 544, 'FRUITS', 11, 'OUTCOME'),
(264, 749, 'DAIRY', 1, 'OUTCOME'),
(265, 240, 'DAIRY', 6, 'INCOME'),
(266, 122, 'DAIRY', 2, 'INCOME'),
(267, 388, 'FRUITS', 10, 'OUTCOME'),
(268, 937, 'VEGETABLES', 3, 'OUTCOME'),
(269, 542, 'FRUITS', 12, 'INCOME'),
(270, 463, 'VEGETABLES', 6, 'INCOME'),
(271, 663, 'MEAT', 7, 'OUTCOME'),
(272, 1000, 'MEAT', 7, 'OUTCOME'),
(273, 117, 'MEAT', 3, 'INCOME'),
(274, 134, 'DAIRY', 11, 'INCOME'),
(275, 869, 'FRUITS', 7, 'OUTCOME'),
(276, 87, 'FRUITS', 3, 'INCOME'),
(277, 705, 'GRAINS', 6, 'INCOME'),
(278, 781, 'FRUITS', 2, 'INCOME'),
(279, 653, 'VEGETABLES', 3, 'OUTCOME'),
(280, 506, 'DAIRY', 12, 'OUTCOME'),
(281, 848, 'VEGETABLES', 5, 'INCOME'),
(282, 725, 'FRUITS', 10, 'INCOME'),
(283, 499, 'VEGETABLES', 10, 'INCOME'),
(284, 232, 'VEGETABLES', 11, 'INCOME'),
(285, 407, 'DAIRY', 9, 'INCOME'),
(286, 318, 'GRAINS', 10, 'INCOME'),
(287, 805, 'VEGETABLES', 13, 'INCOME'),
(288, 207, 'GRAINS', 13, 'OUTCOME'),
(289, 758, 'GRAINS', 11, 'INCOME'),
(290, 439, 'DAIRY', 1, 'OUTCOME'),
(291, 207, 'FRUITS', 4, 'INCOME'),
(292, 656, 'DAIRY', 11, 'INCOME'),
(293, 81, 'DAIRY', 5, 'INCOME'),
(294, 542, 'MEAT', 1, 'INCOME'),
(295, 724, 'FRUITS', 2, 'OUTCOME'),
(296, 404, 'FRUITS', 9, 'OUTCOME'),
(297, 351, 'GRAINS', 5, 'OUTCOME'),
(298, 878, 'GRAINS', 11, 'OUTCOME'),
(299, 181, 'VEGETABLES', 11, 'OUTCOME'),
(300, 812, 'VEGETABLES', 8, 'OUTCOME'),
(301, 534, 'GRAINS', 12, 'OUTCOME'),
(302, 194, 'VEGETABLES', 5, 'OUTCOME'),
(303, 600, 'MEAT', 2, 'OUTCOME'),
(304, 169, 'MEAT', 8, 'OUTCOME'),
(305, 957, 'GRAINS', 7, 'OUTCOME'),
(306, 133, 'MEAT', 3, 'OUTCOME'),
(307, 580, 'MEAT', 2, 'OUTCOME'),
(308, 225, 'GRAINS', 1, 'OUTCOME'),
(309, 716, 'VEGETABLES', 4, 'INCOME'),
(310, 995, 'GRAINS', 12, 'OUTCOME'),
(311, 809, 'VEGETABLES', 4, 'OUTCOME'),
(312, 833, 'MEAT', 5, 'OUTCOME'),
(313, 357, 'DAIRY', 13, 'INCOME'),
(314, 813, 'FRUITS', 12, 'INCOME'),
(315, 774, 'GRAINS', 12, 'INCOME'),
(316, 76, 'DAIRY', 1, 'OUTCOME'),
(317, 623, 'MEAT', 12, 'INCOME'),
(318, 565, 'GRAINS', 8, 'OUTCOME'),
(319, 840, 'VEGETABLES', 2, 'INCOME'),
(320, 85, 'MEAT', 9, 'INCOME'),
(321, 391, 'DAIRY', 9, 'INCOME'),
(322, 941, 'DAIRY', 11, 'INCOME'),
(323, 509, 'VEGETABLES', 12, 'INCOME'),
(324, 322, 'GRAINS', 2, 'INCOME'),
(325, 226, 'FRUITS', 1, 'OUTCOME'),
(326, 630, 'DAIRY', 6, 'INCOME'),
(327, 458, 'GRAINS', 11, 'INCOME'),
(328, 582, 'FRUITS', 1, 'INCOME'),
(329, 235, 'FRUITS', 1, 'INCOME'),
(330, 543, 'FRUITS', 10, 'INCOME'),
(331, 497, 'VEGETABLES', 4, 'OUTCOME'),
(332, 916, 'FRUITS', 8, 'OUTCOME'),
(333, 243, 'MEAT', 7, 'INCOME'),
(334, 529, 'FRUITS', 9, 'INCOME'),
(335, 245, 'GRAINS', 11, 'INCOME'),
(336, 467, 'DAIRY', 12, 'INCOME'),
(337, 797, 'FRUITS', 7, 'INCOME'),
(338, 406, 'MEAT', 4, 'OUTCOME'),
(339, 291, 'FRUITS', 11, 'OUTCOME'),
(340, 869, 'FRUITS', 10, 'INCOME'),
(341, 905, 'FRUITS', 9, 'OUTCOME'),
(342, 631, 'MEAT', 8, 'OUTCOME'),
(343, 534, 'DAIRY', 2, 'OUTCOME'),
(344, 361, 'GRAINS', 1, 'OUTCOME'),
(345, 906, 'FRUITS', 6, 'INCOME'),
(346, 104, 'GRAINS', 13, 'OUTCOME'),
(347, 379, 'MEAT', 4, 'INCOME'),
(348, 112, 'GRAINS', 1, 'INCOME'),
(349, 934, 'DAIRY', 4, 'INCOME'),
(350, 89, 'FRUITS', 2, 'INCOME'),
(351, 255, 'VEGETABLES', 13, 'INCOME'),
(352, 740, 'VEGETABLES', 13, 'INCOME'),
(353, 614, 'GRAINS', 9, 'INCOME'),
(354, 875, 'GRAINS', 6, 'OUTCOME'),
(355, 624, 'VEGETABLES', 7, 'OUTCOME'),
(356, 80, 'DAIRY', 11, 'INCOME'),
(357, 502, 'VEGETABLES', 13, 'OUTCOME'),
(358, 531, 'GRAINS', 6, 'INCOME'),
(359, 907, 'FRUITS', 10, 'OUTCOME'),
(360, 777, 'FRUITS', 4, 'INCOME'),
(361, 568, 'GRAINS', 9, 'OUTCOME'),
(362, 401, 'MEAT', 1, 'OUTCOME'),
(363, 522, 'DAIRY', 10, 'INCOME'),
(364, 68, 'FRUITS', 11, 'OUTCOME'),
(365, 501, 'DAIRY', 6, 'INCOME'),
(366, 446, 'MEAT', 9, 'OUTCOME'),
(367, 370, 'GRAINS', 2, 'OUTCOME'),
(368, 786, 'FRUITS', 1, 'INCOME'),
(369, 342, 'GRAINS', 9, 'OUTCOME'),
(370, 645, 'FRUITS', 4, 'OUTCOME'),
(371, 621, 'FRUITS', 4, 'OUTCOME'),
(372, 57, 'FRUITS', 10, 'INCOME'),
(373, 565, 'MEAT', 13, 'OUTCOME'),
(374, 951, 'MEAT', 7, 'INCOME'),
(375, 254, 'VEGETABLES', 6, 'INCOME'),
(376, 638, 'FRUITS', 1, 'INCOME'),
(377, 762, 'MEAT', 4, 'OUTCOME'),
(378, 878, 'DAIRY', 2, 'OUTCOME'),
(379, 84, 'VEGETABLES', 2, 'INCOME'),
(380, 925, 'GRAINS', 11, 'INCOME'),
(381, 924, 'FRUITS', 5, 'OUTCOME'),
(382, 528, 'DAIRY', 6, 'INCOME'),
(383, 846, 'GRAINS', 12, 'INCOME'),
(384, 362, 'FRUITS', 8, 'INCOME'),
(385, 226, 'GRAINS', 1, 'OUTCOME'),
(386, 917, 'DAIRY', 3, 'OUTCOME'),
(387, 313, 'FRUITS', 5, 'INCOME'),
(388, 184, 'DAIRY', 4, 'OUTCOME'),
(389, 222, 'VEGETABLES', 2, 'INCOME'),
(390, 400, 'VEGETABLES', 7, 'OUTCOME'),
(391, 754, 'FRUITS', 7, 'INCOME'),
(392, 818, 'DAIRY', 9, 'OUTCOME'),
(393, 699, 'FRUITS', 9, 'OUTCOME'),
(394, 232, 'VEGETABLES', 1, 'OUTCOME'),
(395, 462, 'VEGETABLES', 1, 'OUTCOME'),
(396, 852, 'GRAINS', 7, 'OUTCOME'),
(397, 224, 'VEGETABLES', 6, 'INCOME'),
(398, 627, 'VEGETABLES', 10, 'INCOME'),
(399, 120, 'VEGETABLES', 4, 'INCOME'),
(400, 492, 'GRAINS', 11, 'OUTCOME'),
(401, 440, 'FRUITS', 1, 'OUTCOME'),
(402, 674, 'GRAINS', 12, 'INCOME'),
(403, 959, 'GRAINS', 3, 'INCOME'),
(404, 522, 'FRUITS', 5, 'OUTCOME'),
(405, 883, 'DAIRY', 3, 'INCOME'),
(406, 497, 'VEGETABLES', 8, 'OUTCOME'),
(407, 958, 'DAIRY', 5, 'OUTCOME'),
(408, 922, 'GRAINS', 9, 'OUTCOME'),
(409, 595, 'FRUITS', 11, 'INCOME'),
(410, 66, 'DAIRY', 9, 'INCOME'),
(411, 877, 'GRAINS', 4, 'OUTCOME'),
(412, 190, 'MEAT', 1, 'OUTCOME'),
(413, 941, 'DAIRY', 13, 'OUTCOME'),
(414, 133, 'GRAINS', 4, 'OUTCOME'),
(415, 197, 'MEAT', 10, 'INCOME'),
(416, 907, 'MEAT', 12, 'OUTCOME'),
(417, 108, 'MEAT', 3, 'OUTCOME'),
(418, 502, 'MEAT', 3, 'INCOME'),
(419, 552, 'VEGETABLES', 3, 'OUTCOME'),
(420, 285, 'VEGETABLES', 4, 'INCOME'),
(421, 375, 'VEGETABLES', 12, 'INCOME'),
(422, 275, 'DAIRY', 2, 'INCOME'),
(423, 627, 'GRAINS', 12, 'OUTCOME'),
(424, 137, 'DAIRY', 12, 'INCOME'),
(425, 786, 'DAIRY', 10, 'INCOME'),
(426, 701, 'MEAT', 9, 'OUTCOME'),
(427, 709, 'DAIRY', 12, 'INCOME'),
(428, 845, 'FRUITS', 4, 'OUTCOME'),
(429, 322, 'FRUITS', 1, 'OUTCOME'),
(430, 931, 'MEAT', 10, 'OUTCOME'),
(431, 964, 'GRAINS', 4, 'OUTCOME'),
(432, 279, 'GRAINS', 9, 'INCOME'),
(433, 408, 'MEAT', 10, 'OUTCOME'),
(434, 364, 'FRUITS', 5, 'INCOME'),
(435, 852, 'GRAINS', 2, 'OUTCOME'),
(436, 922, 'FRUITS', 2, 'INCOME'),
(437, 806, 'VEGETABLES', 13, 'OUTCOME'),
(438, 408, 'FRUITS', 9, 'INCOME'),
(439, 717, 'DAIRY', 1, 'OUTCOME'),
(440, 548, 'VEGETABLES', 3, 'INCOME'),
(441, 122, 'MEAT', 11, 'OUTCOME'),
(442, 907, 'DAIRY', 3, 'INCOME'),
(443, 334, 'MEAT', 11, 'OUTCOME'),
(444, 409, 'MEAT', 6, 'OUTCOME'),
(445, 138, 'GRAINS', 4, 'OUTCOME'),
(446, 254, 'DAIRY', 12, 'OUTCOME'),
(447, 469, 'VEGETABLES', 12, 'INCOME'),
(448, 656, 'DAIRY', 12, 'OUTCOME'),
(449, 563, 'VEGETABLES', 6, 'OUTCOME'),
(450, 60, 'GRAINS', 6, 'INCOME'),
(451, 814, 'VEGETABLES', 5, 'INCOME'),
(452, 94, 'MEAT', 4, 'OUTCOME'),
(453, 386, 'DAIRY', 6, 'INCOME'),
(454, 919, 'DAIRY', 12, 'OUTCOME'),
(455, 883, 'GRAINS', 2, 'INCOME'),
(456, 634, 'MEAT', 4, 'INCOME'),
(457, 826, 'DAIRY', 11, 'OUTCOME'),
(458, 651, 'VEGETABLES', 10, 'INCOME'),
(459, 287, 'VEGETABLES', 11, 'INCOME'),
(460, 351, 'MEAT', 7, 'OUTCOME'),
(461, 216, 'VEGETABLES', 3, 'OUTCOME'),
(462, 986, 'DAIRY', 11, 'OUTCOME'),
(463, 990, 'GRAINS', 12, 'OUTCOME'),
(464, 900, 'DAIRY', 2, 'OUTCOME'),
(465, 827, 'FRUITS', 3, 'INCOME'),
(466, 763, 'FRUITS', 2, 'OUTCOME'),
(467, 150, 'FRUITS', 8, 'OUTCOME'),
(468, 994, 'VEGETABLES', 8, 'OUTCOME'),
(469, 336, 'VEGETABLES', 13, 'OUTCOME'),
(470, 296, 'FRUITS', 8, 'INCOME'),
(471, 577, 'FRUITS', 3, 'OUTCOME'),
(472, 476, 'FRUITS', 1, 'OUTCOME'),
(473, 506, 'DAIRY', 13, 'INCOME'),
(474, 473, 'FRUITS', 2, 'OUTCOME'),
(475, 933, 'DAIRY', 7, 'INCOME'),
(476, 546, 'MEAT', 10, 'INCOME'),
(477, 181, 'DAIRY', 9, 'OUTCOME'),
(478, 880, 'MEAT', 6, 'INCOME'),
(479, 736, 'VEGETABLES', 3, 'INCOME'),
(480, 126, 'GRAINS', 4, 'OUTCOME'),
(481, 561, 'FRUITS', 5, 'OUTCOME'),
(482, 910, 'FRUITS', 4, 'OUTCOME'),
(483, 722, 'DAIRY', 10, 'INCOME'),
(484, 345, 'VEGETABLES', 4, 'INCOME'),
(485, 761, 'VEGETABLES', 1, 'OUTCOME'),
(486, 748, 'GRAINS', 10, 'OUTCOME'),
(487, 294, 'DAIRY', 12, 'INCOME'),
(488, 166, 'GRAINS', 5, 'OUTCOME'),
(489, 769, 'DAIRY', 8, 'INCOME'),
(490, 853, 'DAIRY', 4, 'INCOME'),
(491, 529, 'DAIRY', 13, 'OUTCOME'),
(492, 470, 'DAIRY', 7, 'OUTCOME'),
(493, 196, 'DAIRY', 11, 'OUTCOME'),
(494, 698, 'VEGETABLES', 13, 'INCOME'),
(495, 346, 'MEAT', 10, 'OUTCOME'),
(496, 764, 'VEGETABLES', 6, 'OUTCOME'),
(497, 451, 'MEAT', 6, 'INCOME'),
(498, 121, 'DAIRY', 8, 'OUTCOME'),
(499, 546, 'VEGETABLES', 13, 'INCOME'),
(500, 168, 'MEAT', 7, 'INCOME');