--liquibase formatted sql
--changeset FDuda:13

INSERT INTO user_transactions(id, amount,description,wallet_id,direction)
VALUES
(1, 672, 'MEAT', 19, 'INCOME'),
(2, 655, 'DAIRY', 15, 'OUTCOME'),
(3, 815, 'GRAINS', 14, 'INCOME'),
(4, 88, 'VEGETABLES', 2, 'INCOME'),
(5, 194, 'MEAT', 20, 'OUTCOME'),
(6, 474, 'GRAINS', 2, 'INCOME'),
(7, 163, 'DAIRY', 2, 'OUTCOME'),
(8, 181, 'FRUITS', 7, 'OUTCOME'),
(9, 707, 'DAIRY', 18, 'INCOME'),
(10, 289, 'GRAINS', 16, 'INCOME'),
(11, 77, 'MEAT', 12, 'OUTCOME'),
(12, 643, 'MEAT', 13, 'INCOME'),
(13, 747, 'FRUITS', 17, 'OUTCOME'),
(14, 962, 'GRAINS', 18, 'INCOME'),
(15, 97, 'FRUITS', 18, 'INCOME'),
(16, 192, 'FRUITS', 11, 'INCOME'),
(17, 361, 'MEAT', 11, 'OUTCOME'),
(18, 163, 'VEGETABLES', 12, 'OUTCOME'),
(19, 576, 'DAIRY', 15, 'OUTCOME'),
(20, 772, 'MEAT', 4, 'INCOME'),
(21, 595, 'VEGETABLES', 6, 'OUTCOME'),
(22, 487, 'VEGETABLES', 20, 'INCOME'),
(23, 896, 'VEGETABLES', 20, 'INCOME'),
(24, 962, 'MEAT', 12, 'INCOME'),
(25, 179, 'DAIRY', 16, 'OUTCOME'),
(26, 337, 'VEGETABLES', 3, 'OUTCOME'),
(27, 118, 'VEGETABLES', 4, 'OUTCOME'),
(28, 146, 'GRAINS', 5, 'INCOME'),
(29, 245, 'VEGETABLES', 19, 'INCOME'),
(30, 717, 'FRUITS', 11, 'INCOME'),
(31, 76, 'FRUITS', 14, 'OUTCOME'),
(32, 871, 'VEGETABLES', 17, 'OUTCOME'),
(33, 212, 'MEAT', 14, 'INCOME'),
(34, 183, 'VEGETABLES', 10, 'OUTCOME'),
(35, 72, 'GRAINS', 16, 'OUTCOME'),
(36, 783, 'FRUITS', 4, 'INCOME'),
(37, 344, 'MEAT', 18, 'INCOME'),
(38, 824, 'GRAINS', 7, 'OUTCOME'),
(39, 207, 'MEAT', 15, 'OUTCOME'),
(40, 727, 'FRUITS', 10, 'OUTCOME'),
(41, 167, 'GRAINS', 18, 'INCOME'),
(42, 798, 'FRUITS', 13, 'OUTCOME'),
(43, 535, 'MEAT', 15, 'OUTCOME'),
(44, 657, 'VEGETABLES', 4, 'OUTCOME'),
(45, 873, 'DAIRY', 10, 'OUTCOME'),
(46, 397, 'FRUITS', 3, 'INCOME'),
(47, 775, 'MEAT', 11, 'OUTCOME'),
(48, 535, 'FRUITS', 9, 'OUTCOME'),
(49, 164, 'FRUITS', 6, 'INCOME'),
(50, 659, 'DAIRY', 2, 'OUTCOME'),
(51, 87, 'MEAT', 13, 'INCOME'),
(52, 329, 'VEGETABLES', 3, 'OUTCOME'),
(53, 85, 'GRAINS', 2, 'OUTCOME'),
(54, 471, 'FRUITS', 16, 'INCOME'),
(55, 630, 'FRUITS', 11, 'OUTCOME'),
(56, 434, 'FRUITS', 11, 'OUTCOME'),
(57, 461, 'VEGETABLES', 19, 'INCOME'),
(58, 662, 'GRAINS', 5, 'INCOME'),
(59, 719, 'VEGETABLES', 10, 'OUTCOME'),
(60, 732, 'FRUITS', 14, 'OUTCOME'),
(61, 96, 'GRAINS', 1, 'OUTCOME'),
(62, 872, 'VEGETABLES', 12, 'OUTCOME'),
(63, 288, 'GRAINS', 9, 'INCOME'),
(64, 967, 'FRUITS', 14, 'OUTCOME'),
(65, 906, 'GRAINS', 14, 'INCOME'),
(66, 295, 'DAIRY', 6, 'INCOME'),
(67, 696, 'MEAT', 13, 'INCOME'),
(68, 280, 'DAIRY', 2, 'OUTCOME'),
(69, 321, 'GRAINS', 15, 'INCOME'),
(70, 245, 'DAIRY', 8, 'OUTCOME'),
(71, 59, 'FRUITS', 13, 'OUTCOME'),
(72, 410, 'MEAT', 18, 'OUTCOME'),
(73, 114, 'DAIRY', 14, 'INCOME'),
(74, 441, 'FRUITS', 13, 'OUTCOME'),
(75, 632, 'VEGETABLES', 18, 'OUTCOME'),
(76, 696, 'MEAT', 17, 'OUTCOME'),
(77, 151, 'DAIRY', 20, 'INCOME'),
(78, 930, 'FRUITS', 17, 'INCOME'),
(79, 166, 'FRUITS', 4, 'INCOME'),
(80, 807, 'FRUITS', 5, 'OUTCOME'),
(81, 189, 'VEGETABLES', 11, 'OUTCOME'),
(82, 79, 'GRAINS', 17, 'OUTCOME'),
(83, 195, 'FRUITS', 5, 'INCOME'),
(84, 623, 'MEAT', 12, 'OUTCOME'),
(85, 652, 'DAIRY', 15, 'OUTCOME'),
(86, 379, 'GRAINS', 4, 'OUTCOME'),
(87, 390, 'FRUITS', 9, 'INCOME'),
(88, 456, 'DAIRY', 15, 'OUTCOME'),
(89, 146, 'GRAINS', 16, 'INCOME'),
(90, 617, 'GRAINS', 6, 'INCOME'),
(91, 70, 'VEGETABLES', 5, 'OUTCOME'),
(92, 371, 'GRAINS', 7, 'OUTCOME'),
(93, 628, 'GRAINS', 2, 'INCOME'),
(94, 763, 'FRUITS', 9, 'INCOME'),
(95, 437, 'FRUITS', 13, 'INCOME'),
(96, 869, 'VEGETABLES', 15, 'OUTCOME'),
(97, 133, 'FRUITS', 1, 'OUTCOME'),
(98, 325, 'FRUITS', 10, 'INCOME'),
(99, 107, 'VEGETABLES', 16, 'INCOME'),
(100, 278, 'VEGETABLES', 13, 'OUTCOME'),
(101, 487, 'MEAT', 17, 'OUTCOME'),
(102, 121, 'DAIRY', 11, 'OUTCOME'),
(103, 850, 'DAIRY', 8, 'OUTCOME'),
(104, 689, 'DAIRY', 11, 'OUTCOME'),
(105, 429, 'MEAT', 9, 'OUTCOME'),
(106, 395, 'FRUITS', 14, 'INCOME'),
(107, 609, 'MEAT', 3, 'INCOME'),
(108, 360, 'FRUITS', 7, 'OUTCOME'),
(109, 144, 'VEGETABLES', 8, 'INCOME'),
(110, 934, 'VEGETABLES', 8, 'OUTCOME'),
(111, 181, 'MEAT', 3, 'OUTCOME'),
(112, 725, 'FRUITS', 11, 'OUTCOME'),
(113, 833, 'DAIRY', 11, 'INCOME'),
(114, 804, 'FRUITS', 5, 'INCOME'),
(115, 331, 'DAIRY', 5, 'OUTCOME'),
(116, 639, 'FRUITS', 3, 'OUTCOME'),
(117, 750, 'GRAINS', 13, 'OUTCOME'),
(118, 451, 'GRAINS', 1, 'OUTCOME'),
(119, 372, 'VEGETABLES', 1, 'OUTCOME'),
(120, 848, 'FRUITS', 9, 'OUTCOME'),
(121, 217, 'FRUITS', 9, 'INCOME'),
(122, 191, 'VEGETABLES', 16, 'OUTCOME'),
(123, 969, 'DAIRY', 19, 'INCOME'),
(124, 548, 'VEGETABLES', 14, 'INCOME'),
(125, 269, 'MEAT', 11, 'OUTCOME'),
(126, 272, 'DAIRY', 2, 'INCOME'),
(127, 991, 'VEGETABLES', 16, 'OUTCOME'),
(128, 218, 'MEAT', 4, 'OUTCOME'),
(129, 93, 'FRUITS', 19, 'INCOME'),
(130, 78, 'DAIRY', 14, 'OUTCOME'),
(131, 638, 'FRUITS', 1, 'INCOME'),
(132, 242, 'DAIRY', 14, 'INCOME'),
(133, 274, 'VEGETABLES', 2, 'INCOME'),
(134, 308, 'FRUITS', 6, 'OUTCOME'),
(135, 517, 'GRAINS', 17, 'OUTCOME'),
(136, 487, 'DAIRY', 10, 'OUTCOME'),
(137, 738, 'DAIRY', 6, 'INCOME'),
(138, 834, 'GRAINS', 20, 'INCOME'),
(139, 711, 'GRAINS', 5, 'INCOME'),
(140, 221, 'MEAT', 3, 'INCOME'),
(141, 896, 'MEAT', 1, 'INCOME'),
(142, 173, 'GRAINS', 7, 'OUTCOME'),
(143, 326, 'DAIRY', 10, 'INCOME'),
(144, 752, 'FRUITS', 13, 'INCOME'),
(145, 373, 'MEAT', 1, 'INCOME'),
(146, 945, 'DAIRY', 1, 'INCOME'),
(147, 180, 'MEAT', 18, 'INCOME'),
(148, 63, 'GRAINS', 8, 'OUTCOME'),
(149, 641, 'FRUITS', 6, 'OUTCOME'),
(150, 743, 'DAIRY', 16, 'OUTCOME'),
(151, 586, 'MEAT', 18, 'INCOME'),
(152, 239, 'VEGETABLES', 11, 'OUTCOME'),
(153, 116, 'GRAINS', 8, 'INCOME'),
(154, 617, 'DAIRY', 18, 'OUTCOME'),
(155, 677, 'GRAINS', 3, 'OUTCOME'),
(156, 968, 'GRAINS', 11, 'OUTCOME'),
(157, 198, 'FRUITS', 15, 'OUTCOME'),
(158, 411, 'FRUITS', 11, 'OUTCOME'),
(159, 485, 'DAIRY', 14, 'OUTCOME'),
(160, 56, 'MEAT', 13, 'INCOME'),
(161, 676, 'MEAT', 7, 'OUTCOME'),
(162, 393, 'VEGETABLES', 14, 'OUTCOME'),
(163, 562, 'MEAT', 3, 'OUTCOME'),
(164, 876, 'VEGETABLES', 13, 'OUTCOME'),
(165, 116, 'DAIRY', 10, 'INCOME'),
(166, 684, 'FRUITS', 6, 'INCOME'),
(167, 727, 'GRAINS', 5, 'INCOME'),
(168, 149, 'MEAT', 9, 'INCOME'),
(169, 336, 'MEAT', 6, 'INCOME'),
(170, 406, 'MEAT', 17, 'OUTCOME'),
(171, 199, 'FRUITS', 15, 'OUTCOME'),
(172, 440, 'MEAT', 15, 'OUTCOME'),
(173, 635, 'GRAINS', 9, 'INCOME'),
(174, 152, 'MEAT', 14, 'INCOME'),
(175, 570, 'GRAINS', 12, 'INCOME'),
(176, 471, 'GRAINS', 18, 'OUTCOME'),
(177, 828, 'DAIRY', 9, 'OUTCOME'),
(178, 771, 'MEAT', 11, 'INCOME'),
(179, 430, 'DAIRY', 20, 'OUTCOME'),
(180, 520, 'MEAT', 17, 'INCOME'),
(181, 656, 'FRUITS', 10, 'INCOME'),
(182, 947, 'MEAT', 6, 'OUTCOME'),
(183, 709, 'VEGETABLES', 4, 'INCOME'),
(184, 471, 'DAIRY', 2, 'OUTCOME'),
(185, 760, 'VEGETABLES', 17, 'OUTCOME'),
(186, 63, 'MEAT', 3, 'OUTCOME'),
(187, 455, 'MEAT', 7, 'OUTCOME'),
(188, 896, 'VEGETABLES', 12, 'OUTCOME'),
(189, 832, 'DAIRY', 18, 'OUTCOME'),
(190, 186, 'DAIRY', 15, 'OUTCOME'),
(191, 195, 'FRUITS', 14, 'INCOME'),
(192, 748, 'DAIRY', 1, 'OUTCOME'),
(193, 638, 'DAIRY', 3, 'INCOME'),
(194, 252, 'GRAINS', 16, 'OUTCOME'),
(195, 887, 'VEGETABLES', 7, 'OUTCOME'),
(196, 268, 'GRAINS', 8, 'OUTCOME'),
(197, 264, 'MEAT', 16, 'INCOME'),
(198, 603, 'VEGETABLES', 16, 'OUTCOME'),
(199, 154, 'GRAINS', 2, 'INCOME'),
(200, 403, 'DAIRY', 7, 'OUTCOME'),
(201, 970, 'MEAT', 4, 'INCOME'),
(202, 809, 'FRUITS', 12, 'INCOME'),
(203, 62, 'GRAINS', 10, 'INCOME'),
(204, 615, 'MEAT', 15, 'OUTCOME'),
(205, 88, 'VEGETABLES', 12, 'OUTCOME'),
(206, 210, 'DAIRY', 15, 'INCOME'),
(207, 511, 'MEAT', 19, 'OUTCOME'),
(208, 602, 'MEAT', 6, 'OUTCOME'),
(209, 827, 'GRAINS', 5, 'INCOME'),
(210, 130, 'GRAINS', 9, 'INCOME'),
(211, 325, 'GRAINS', 5, 'OUTCOME'),
(212, 222, 'MEAT', 6, 'INCOME'),
(213, 772, 'GRAINS', 19, 'INCOME'),
(214, 406, 'GRAINS', 19, 'INCOME'),
(215, 663, 'DAIRY', 12, 'OUTCOME'),
(216, 122, 'MEAT', 8, 'OUTCOME'),
(217, 180, 'DAIRY', 2, 'OUTCOME'),
(218, 885, 'GRAINS', 9, 'INCOME'),
(219, 233, 'MEAT', 17, 'OUTCOME'),
(220, 116, 'MEAT', 10, 'OUTCOME'),
(221, 586, 'MEAT', 10, 'OUTCOME'),
(222, 93, 'MEAT', 15, 'OUTCOME'),
(223, 641, 'DAIRY', 15, 'INCOME'),
(224, 491, 'VEGETABLES', 9, 'OUTCOME'),
(225, 874, 'DAIRY', 3, 'INCOME'),
(226, 401, 'GRAINS', 19, 'OUTCOME'),
(227, 198, 'DAIRY', 17, 'OUTCOME'),
(228, 380, 'DAIRY', 10, 'OUTCOME'),
(229, 953, 'FRUITS', 6, 'INCOME'),
(230, 867, 'FRUITS', 17, 'INCOME'),
(231, 688, 'MEAT', 13, 'OUTCOME'),
(232, 564, 'GRAINS', 13, 'OUTCOME'),
(233, 439, 'GRAINS', 17, 'INCOME'),
(234, 998, 'MEAT', 18, 'INCOME'),
(235, 476, 'VEGETABLES', 17, 'INCOME'),
(236, 290, 'FRUITS', 19, 'OUTCOME'),
(237, 415, 'DAIRY', 4, 'OUTCOME'),
(238, 597, 'FRUITS', 9, 'OUTCOME'),
(239, 949, 'DAIRY', 1, 'INCOME'),
(240, 392, 'VEGETABLES', 5, 'INCOME'),
(241, 729, 'FRUITS', 1, 'INCOME'),
(242, 573, 'GRAINS', 12, 'INCOME'),
(243, 460, 'DAIRY', 2, 'OUTCOME'),
(244, 292, 'FRUITS', 18, 'OUTCOME'),
(245, 642, 'VEGETABLES', 15, 'INCOME'),
(246, 558, 'FRUITS', 8, 'INCOME'),
(247, 731, 'FRUITS', 7, 'INCOME'),
(248, 718, 'FRUITS', 7, 'INCOME'),
(249, 620, 'MEAT', 6, 'INCOME'),
(250, 95, 'VEGETABLES', 18, 'OUTCOME'),
(251, 172, 'DAIRY', 16, 'INCOME'),
(252, 779, 'GRAINS', 10, 'OUTCOME'),
(253, 399, 'DAIRY', 13, 'INCOME'),
(254, 120, 'FRUITS', 18, 'INCOME'),
(255, 836, 'FRUITS', 9, 'INCOME'),
(256, 799, 'DAIRY', 6, 'OUTCOME'),
(257, 81, 'FRUITS', 10, 'OUTCOME'),
(258, 246, 'MEAT', 11, 'OUTCOME'),
(259, 474, 'VEGETABLES', 8, 'INCOME'),
(260, 326, 'VEGETABLES', 11, 'INCOME'),
(261, 702, 'FRUITS', 6, 'OUTCOME'),
(262, 128, 'VEGETABLES', 16, 'OUTCOME'),
(263, 522, 'GRAINS', 6, 'INCOME'),
(264, 380, 'VEGETABLES', 5, 'OUTCOME'),
(265, 732, 'VEGETABLES', 1, 'OUTCOME'),
(266, 717, 'GRAINS', 4, 'OUTCOME'),
(267, 874, 'GRAINS', 7, 'OUTCOME'),
(268, 254, 'VEGETABLES', 9, 'INCOME'),
(269, 186, 'MEAT', 1, 'INCOME'),
(270, 897, 'FRUITS', 18, 'INCOME'),
(271, 169, 'MEAT', 11, 'OUTCOME'),
(272, 688, 'MEAT', 1, 'OUTCOME'),
(273, 164, 'DAIRY', 17, 'INCOME'),
(274, 442, 'GRAINS', 19, 'INCOME'),
(275, 128, 'VEGETABLES', 9, 'INCOME'),
(276, 435, 'VEGETABLES', 6, 'INCOME'),
(277, 98, 'DAIRY', 7, 'INCOME'),
(278, 694, 'GRAINS', 10, 'INCOME'),
(279, 565, 'GRAINS', 1, 'INCOME'),
(280, 224, 'MEAT', 6, 'INCOME'),
(281, 682, 'MEAT', 19, 'INCOME'),
(282, 827, 'VEGETABLES', 19, 'INCOME'),
(283, 400, 'MEAT', 7, 'OUTCOME'),
(284, 726, 'DAIRY', 20, 'OUTCOME'),
(285, 424, 'GRAINS', 6, 'INCOME'),
(286, 283, 'GRAINS', 15, 'INCOME'),
(287, 502, 'VEGETABLES', 11, 'OUTCOME'),
(288, 399, 'MEAT', 5, 'OUTCOME'),
(289, 79, 'VEGETABLES', 10, 'OUTCOME'),
(290, 477, 'FRUITS', 6, 'OUTCOME'),
(291, 308, 'FRUITS', 9, 'OUTCOME'),
(292, 511, 'DAIRY', 18, 'OUTCOME'),
(293, 498, 'GRAINS', 1, 'INCOME'),
(294, 984, 'VEGETABLES', 3, 'INCOME'),
(295, 872, 'MEAT', 16, 'OUTCOME'),
(296, 453, 'DAIRY', 16, 'OUTCOME'),
(297, 799, 'FRUITS', 9, 'INCOME'),
(298, 839, 'VEGETABLES', 1, 'OUTCOME'),
(299, 589, 'MEAT', 3, 'OUTCOME'),
(300, 317, 'FRUITS', 10, 'INCOME'),
(301, 422, 'VEGETABLES', 19, 'OUTCOME'),
(302, 640, 'VEGETABLES', 19, 'INCOME'),
(303, 61, 'VEGETABLES', 9, 'INCOME'),
(304, 370, 'VEGETABLES', 14, 'INCOME'),
(305, 463, 'VEGETABLES', 4, 'OUTCOME'),
(306, 858, 'DAIRY', 1, 'INCOME'),
(307, 351, 'DAIRY', 2, 'OUTCOME'),
(308, 90, 'FRUITS', 12, 'INCOME'),
(309, 493, 'GRAINS', 20, 'INCOME'),
(310, 616, 'VEGETABLES', 16, 'OUTCOME'),
(311, 899, 'VEGETABLES', 9, 'OUTCOME'),
(312, 365, 'DAIRY', 6, 'OUTCOME'),
(313, 331, 'VEGETABLES', 12, 'OUTCOME'),
(314, 148, 'MEAT', 13, 'INCOME'),
(315, 705, 'MEAT', 10, 'INCOME'),
(316, 216, 'DAIRY', 17, 'OUTCOME'),
(317, 835, 'VEGETABLES', 16, 'INCOME'),
(318, 288, 'DAIRY', 9, 'INCOME'),
(319, 850, 'VEGETABLES', 20, 'OUTCOME'),
(320, 307, 'FRUITS', 10, 'INCOME'),
(321, 490, 'MEAT', 17, 'OUTCOME'),
(322, 378, 'DAIRY', 13, 'OUTCOME'),
(323, 79, 'VEGETABLES', 20, 'OUTCOME'),
(324, 553, 'FRUITS', 3, 'OUTCOME'),
(325, 635, 'MEAT', 13, 'OUTCOME'),
(326, 530, 'DAIRY', 10, 'INCOME'),
(327, 656, 'GRAINS', 18, 'OUTCOME'),
(328, 405, 'FRUITS', 7, 'INCOME'),
(329, 485, 'GRAINS', 9, 'OUTCOME'),
(330, 298, 'GRAINS', 2, 'INCOME'),
(331, 974, 'DAIRY', 6, 'INCOME'),
(332, 212, 'GRAINS', 2, 'INCOME'),
(333, 568, 'MEAT', 2, 'INCOME'),
(334, 196, 'GRAINS', 1, 'OUTCOME'),
(335, 643, 'DAIRY', 8, 'INCOME'),
(336, 140, 'FRUITS', 14, 'INCOME'),
(337, 756, 'DAIRY', 7, 'INCOME'),
(338, 190, 'GRAINS', 7, 'INCOME'),
(339, 827, 'FRUITS', 19, 'OUTCOME'),
(340, 471, 'VEGETABLES', 3, 'INCOME'),
(341, 139, 'GRAINS', 8, 'OUTCOME'),
(342, 86, 'VEGETABLES', 3, 'INCOME'),
(343, 850, 'VEGETABLES', 2, 'INCOME'),
(344, 442, 'DAIRY', 7, 'OUTCOME'),
(345, 217, 'DAIRY', 20, 'INCOME'),
(346, 911, 'GRAINS', 12, 'OUTCOME'),
(347, 134, 'MEAT', 11, 'INCOME'),
(348, 604, 'MEAT', 5, 'OUTCOME'),
(349, 516, 'GRAINS', 14, 'OUTCOME'),
(350, 877, 'MEAT', 3, 'OUTCOME'),
(351, 636, 'MEAT', 13, 'INCOME'),
(352, 177, 'FRUITS', 17, 'INCOME'),
(353, 927, 'VEGETABLES', 7, 'INCOME'),
(354, 647, 'MEAT', 10, 'OUTCOME'),
(355, 75, 'FRUITS', 4, 'OUTCOME'),
(356, 676, 'FRUITS', 11, 'INCOME'),
(357, 928, 'MEAT', 13, 'INCOME'),
(358, 360, 'GRAINS', 13, 'OUTCOME'),
(359, 557, 'FRUITS', 1, 'INCOME'),
(360, 246, 'FRUITS', 9, 'OUTCOME'),
(361, 960, 'DAIRY', 9, 'OUTCOME'),
(362, 881, 'FRUITS', 17, 'OUTCOME'),
(363, 95, 'DAIRY', 2, 'INCOME'),
(364, 916, 'FRUITS', 7, 'OUTCOME'),
(365, 182, 'MEAT', 2, 'OUTCOME'),
(366, 982, 'FRUITS', 4, 'INCOME'),
(367, 885, 'GRAINS', 3, 'INCOME'),
(368, 333, 'GRAINS', 12, 'OUTCOME'),
(369, 213, 'VEGETABLES', 10, 'INCOME'),
(370, 449, 'GRAINS', 5, 'INCOME'),
(371, 907, 'FRUITS', 5, 'OUTCOME'),
(372, 970, 'VEGETABLES', 1, 'INCOME'),
(373, 372, 'VEGETABLES', 8, 'OUTCOME'),
(374, 840, 'FRUITS', 18, 'INCOME'),
(375, 125, 'DAIRY', 14, 'INCOME'),
(376, 310, 'MEAT', 9, 'OUTCOME'),
(377, 497, 'VEGETABLES', 17, 'OUTCOME'),
(378, 730, 'GRAINS', 13, 'INCOME'),
(379, 463, 'VEGETABLES', 13, 'OUTCOME'),
(380, 418, 'VEGETABLES', 6, 'INCOME'),
(381, 628, 'FRUITS', 2, 'OUTCOME'),
(382, 648, 'GRAINS', 10, 'INCOME'),
(383, 413, 'FRUITS', 4, 'INCOME'),
(384, 191, 'MEAT', 2, 'INCOME'),
(385, 982, 'DAIRY', 7, 'INCOME'),
(386, 577, 'GRAINS', 14, 'OUTCOME'),
(387, 241, 'FRUITS', 16, 'INCOME'),
(388, 556, 'FRUITS', 13, 'OUTCOME'),
(389, 857, 'GRAINS', 19, 'INCOME'),
(390, 783, 'DAIRY', 4, 'OUTCOME'),
(391, 810, 'GRAINS', 8, 'INCOME'),
(392, 354, 'DAIRY', 14, 'OUTCOME'),
(393, 345, 'MEAT', 13, 'OUTCOME'),
(394, 962, 'GRAINS', 2, 'OUTCOME'),
(395, 694, 'FRUITS', 7, 'OUTCOME'),
(396, 905, 'GRAINS', 10, 'INCOME'),
(397, 347, 'FRUITS', 4, 'OUTCOME'),
(398, 276, 'FRUITS', 17, 'INCOME'),
(399, 810, 'GRAINS', 15, 'INCOME'),
(400, 336, 'FRUITS', 14, 'OUTCOME'),
(401, 399, 'GRAINS', 7, 'INCOME'),
(402, 425, 'MEAT', 6, 'INCOME'),
(403, 357, 'DAIRY', 5, 'OUTCOME'),
(404, 531, 'GRAINS', 8, 'OUTCOME'),
(405, 918, 'FRUITS', 16, 'INCOME'),
(406, 249, 'DAIRY', 13, 'OUTCOME'),
(407, 132, 'DAIRY', 19, 'INCOME'),
(408, 236, 'FRUITS', 3, 'OUTCOME'),
(409, 916, 'DAIRY', 9, 'INCOME'),
(410, 953, 'MEAT', 12, 'OUTCOME'),
(411, 988, 'MEAT', 11, 'OUTCOME'),
(412, 887, 'FRUITS', 10, 'INCOME'),
(413, 900, 'DAIRY', 7, 'INCOME'),
(414, 54, 'DAIRY', 20, 'OUTCOME'),
(415, 907, 'VEGETABLES', 8, 'INCOME'),
(416, 323, 'VEGETABLES', 12, 'OUTCOME'),
(417, 168, 'DAIRY', 4, 'OUTCOME'),
(418, 680, 'GRAINS', 2, 'INCOME'),
(419, 227, 'GRAINS', 1, 'INCOME'),
(420, 790, 'FRUITS', 20, 'INCOME'),
(421, 491, 'GRAINS', 6, 'OUTCOME'),
(422, 672, 'VEGETABLES', 8, 'OUTCOME'),
(423, 133, 'DAIRY', 2, 'INCOME'),
(424, 701, 'GRAINS', 9, 'OUTCOME'),
(425, 103, 'GRAINS', 12, 'OUTCOME'),
(426, 165, 'GRAINS', 12, 'INCOME'),
(427, 327, 'DAIRY', 3, 'INCOME'),
(428, 910, 'DAIRY', 17, 'INCOME'),
(429, 983, 'GRAINS', 4, 'INCOME'),
(430, 408, 'DAIRY', 4, 'INCOME'),
(431, 578, 'GRAINS', 12, 'OUTCOME'),
(432, 168, 'DAIRY', 20, 'INCOME'),
(433, 90, 'VEGETABLES', 15, 'INCOME'),
(434, 705, 'DAIRY', 10, 'INCOME'),
(435, 798, 'VEGETABLES', 4, 'OUTCOME'),
(436, 767, 'DAIRY', 5, 'INCOME'),
(437, 146, 'FRUITS', 20, 'OUTCOME'),
(438, 164, 'MEAT', 1, 'OUTCOME'),
(439, 144, 'MEAT', 14, 'INCOME'),
(440, 781, 'FRUITS', 19, 'INCOME'),
(441, 102, 'FRUITS', 16, 'INCOME'),
(442, 501, 'GRAINS', 12, 'INCOME'),
(443, 150, 'VEGETABLES', 18, 'OUTCOME'),
(444, 897, 'FRUITS', 1, 'OUTCOME'),
(445, 874, 'MEAT', 6, 'INCOME'),
(446, 642, 'VEGETABLES', 4, 'OUTCOME'),
(447, 342, 'MEAT', 10, 'OUTCOME'),
(448, 748, 'DAIRY', 17, 'INCOME'),
(449, 633, 'MEAT', 15, 'INCOME'),
(450, 926, 'GRAINS', 5, 'OUTCOME'),
(451, 812, 'FRUITS', 8, 'INCOME'),
(452, 125, 'GRAINS', 7, 'INCOME'),
(453, 305, 'MEAT', 19, 'INCOME'),
(454, 494, 'GRAINS', 19, 'OUTCOME'),
(455, 143, 'DAIRY', 8, 'OUTCOME'),
(456, 716, 'DAIRY', 10, 'OUTCOME'),
(457, 118, 'FRUITS', 2, 'OUTCOME'),
(458, 124, 'MEAT', 9, 'INCOME'),
(459, 540, 'GRAINS', 13, 'INCOME'),
(460, 779, 'DAIRY', 15, 'INCOME'),
(461, 840, 'VEGETABLES', 10, 'OUTCOME'),
(462, 654, 'VEGETABLES', 9, 'OUTCOME'),
(463, 377, 'DAIRY', 13, 'INCOME'),
(464, 824, 'GRAINS', 5, 'INCOME'),
(465, 997, 'DAIRY', 17, 'OUTCOME'),
(466, 281, 'FRUITS', 7, 'INCOME'),
(467, 716, 'MEAT', 8, 'INCOME'),
(468, 580, 'GRAINS', 11, 'OUTCOME'),
(469, 291, 'DAIRY', 19, 'OUTCOME'),
(470, 402, 'FRUITS', 14, 'OUTCOME'),
(471, 288, 'GRAINS', 14, 'OUTCOME'),
(472, 788, 'VEGETABLES', 20, 'INCOME'),
(473, 380, 'VEGETABLES', 11, 'INCOME'),
(474, 878, 'GRAINS', 15, 'INCOME'),
(475, 440, 'FRUITS', 8, 'INCOME'),
(476, 527, 'VEGETABLES', 5, 'INCOME'),
(477, 385, 'MEAT', 8, 'OUTCOME'),
(478, 238, 'MEAT', 17, 'INCOME'),
(479, 944, 'VEGETABLES', 15, 'OUTCOME'),
(480, 690, 'MEAT', 17, 'INCOME'),
(481, 623, 'VEGETABLES', 5, 'OUTCOME'),
(482, 126, 'MEAT', 9, 'OUTCOME'),
(483, 767, 'FRUITS', 6, 'INCOME'),
(484, 972, 'MEAT', 9, 'INCOME'),
(485, 421, 'DAIRY', 8, 'INCOME'),
(486, 459, 'FRUITS', 15, 'OUTCOME'),
(487, 260, 'GRAINS', 6, 'INCOME'),
(488, 374, 'DAIRY', 16, 'INCOME'),
(489, 317, 'DAIRY', 17, 'INCOME'),
(490, 79, 'GRAINS', 5, 'INCOME'),
(491, 901, 'GRAINS', 8, 'INCOME'),
(492, 280, 'DAIRY', 14, 'OUTCOME'),
(493, 429, 'GRAINS', 17, 'INCOME'),
(494, 105, 'VEGETABLES', 12, 'OUTCOME'),
(495, 632, 'VEGETABLES', 4, 'OUTCOME'),
(496, 728, 'VEGETABLES', 6, 'OUTCOME'),
(497, 813, 'FRUITS', 15, 'OUTCOME'),
(498, 410, 'MEAT', 12, 'INCOME'),
(499, 293, 'MEAT', 6, 'INCOME'),
(500, 156, 'GRAINS', 4, 'OUTCOME');