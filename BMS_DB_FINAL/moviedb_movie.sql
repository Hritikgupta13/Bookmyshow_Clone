-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: moviedb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `poster` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `trailer` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'THOR','https://upload.wikimedia.org/wikipedia/en/9/95/Thor_%28film%29_poster.jpg','The powerful but arrogant god Thor is cast out of Asgard to live amongst humans in Midgard (Earth), where he soon becomes one of their finest defenders.','https://imdb-video.media-imdb.com/vi1431476761/1434659607842-pgv4ql-1616202507839.mp4?Expires=1679721843&Signature=d5shMtYToObXjU90Bt0pRTjYspO2c6MkQCeCIapL1kDWnUf0HPINGYv7RhHbRUlNuaQtD8xdjqb3x5PpGwxuvZF64zixFvhubCGMCCue42OLwWqxjhebeqsxXeiXb5swoR9~xkp9d6vhdtyjahUcfX6MN1lXnFMnaeGj4yyDclBuYgH6DUucMmPSPrBcpE0fJ7QWejQsadlglzaUShV-uynm098acqZzTTzDmlghgHii9wSVoVA5EvolsPA4NMAs5mvv1CQ3vd25qqzM2Gct6kBLXBGgGlecBipdU8etVvfTMMqXJ2Mbqz9nMjspO~y3fDytzFh8FgK95m0~HYd3Jg__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),(2,'VIKRAM','https://upload.wikimedia.org/wikipedia/en/9/93/Vikram_2022_poster.jpg','A high-octane action film where a special investigator is assigned a case of serial Killings, he finds the case is not what it seems to be and leading down this path is only going to end in a war between everyone involved.','https://imdb-video.media-imdb.com/vi3381510681/1434659607842-pgv4ql-1652773206518.mp4?Expires=1679674586&Signature=TrL1wpNAvDiXdzfS3FgdytCwHkKy3KlwRTTGofRJjAVK0t-jaZgblxPffKqmDITrmBnMIyBzFWvPI2LatDRckPystw38vWB2cQrtdEfO~E9uhUms0HtahYHKHBiv6bQB8tWEDgeiVV4gsY-uQ1n8J5XkGyNTlfJpKmMYjjCtZstlQTBy93HP~lTJ6VyYYkH85UQYl5qxOGg7Fk0w3O5nyiNgpZf9OWzCa7POf5U--DDFNZc9FGAcqfKR2JX5q0V20YYFGULvMWaAkARxLHcHwzLyhMC2etIvjjAEznn3o5mi1gCb6mm7GbfyUTC5HZeMVOxl2JPHDb49n~yHqJ6R0g__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),(9,'AVATAR','https://upload.wikimedia.org/wikipedia/en/5/54/Avatar_The_Way_of_Water_poster.jpg','Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na\'vi race to protect their home.','https://imdb-video.media-imdb.com/vi3565864217/1434659607842-pgv4ql-1669124569701.mp4?Expires=1679559667&Signature=CFYX-NE3C5O61XCzPJ7nMsDR0habzZpIpWFzwznOm7EqQ0t3tYAny0XgDapCWNxc1a0JNmHBB6nFcsxPGkoLnOJCigYyv4TdKpJV4GmnXCEeU~e-qnc32b0a~PSlVblbXm7fmLuL7aBed7xeiPE01HPV2w~ievL4N1w3MZ-nYLf-pcNe3QNlzrsHlGnr3OZEtz64TWay88DYCggPfHT41myNpy~n0omfmUTRoRGX5zjfCTIihE9nKvHDhKBFNAEBbhzms8mKbiOFAzZxoEV7K2lKDAnJhEA1DwemDPfAx9mouMC5qkSXMnMMLawXHiBenl8IIYHPs69DXEUAFIUKpg__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),(11,'IRON MAN','https://upload.wikimedia.org/wikipedia/en/0/02/Iron_Man_%282008_film%29_poster.jpg','After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.','https://imdb-video.media-imdb.com/vi447873305/1434659607842-pgv4ql-1616202365476.mp4?Expires=1679559754&Signature=VwR3~HyRCDnYpwejIwD4GGveSby69IGk7YYbQjGmXEExaVKfUnIBxSmNN~ZTkzFJdbzVPjkjjtTYWz7w8qXKzvxvMhPqzByahItc3hqWhEzaaQHzqxj30Irh78FAejHsAKk8KPVprgqpppEj5RFeUIw0ZHBCN8qirYP2S1P-hMGzh~-CqgRsfxqxlBZO-F3y8uHf8xCFoRerGEvDDLBx5m3e98r1PRyN19pTswP9c-VjM0-tCBlfMmj9WXpraRI8puBuEaConDttlDZYDc6Dzz-dMEsnG4f6ApkOkIB~4b-BsWxaRpSc3a2kpQY7~v~lV6B5gHAV6UBD1jyCivSd2Q__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),(13,'BATMAN','https://upload.wikimedia.org/wikipedia/en/f/ff/The_Batman_%28film%29_poster.jpg','When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city\'s hidden corruption and question his family\'s involvement.','https://imdb-video.media-imdb.com/vi3215114777/1434659607842-pgv4ql-1649797798432.mp4?Expires=1679560096&Signature=AV1O9sn1N8ppZJ1yoJf4p1GkBSpIQ0eroNTgZugw1LlVg7eWMIJP1j5ACOcsPlQw8QUifMQZm3Ip51NB3cSSpiuSjd9dHbVImGFNQYHhy8dToxCezklwbNCu36e4C7Wxe9u~f5eRCtX8xRGA~sY-4s59S2rSkQ1K~55BMx~3QoFuVhprLi-lJCpJBTwQGYs3Sl4RkQeL5NeiHt~7CTlwHd38YG1R2zR504uP-DlRxNp5aVLrcrmpObbcUv~AGCi2Ko8sEyRsWSiYkHsWKYSLmjHSdpb2i1z235qiHdK6utoIpPTd8WGmbQfHy-9xjalBn~QgZTuFcEqD9l1gT1vQjw__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),(53,'TITANIC','https://upload.wikimedia.org/wikipedia/en/1/18/Titanic_%281997_film%29_poster.png','A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.','https://imdb-video.media-imdb.com/vi1740686617/1434659607842-pgv4ql-1673374118732.mp4?Expires=1679558299&Signature=jKSbf1CzaiKfIcKoWVIVLy1nalsh92-YAEA1uFIR~TGMlCGqfKTYtZQDVDX7IbvCI-FkCDs54ErqDQZLwv2V-vxpEDGMMwJvnhdHdX71vRU-e4EYqHGezhUCU3XICMXb-O9Z5WW1vI8-BCEToQTS3h72xdOqmuqhEieVu4bbvIJa1hGOHq6vZR7Fsu-6i3alEL8p7Ug7q58Q7gVW4n8ZeZxaJAVBjBZYmddy1j7qaL9IvIsDxawhbEl7CRGV5UDOllEX15JiQy2Y9r531NqVu-1Rp95YIjnKhVAdvIevf8iMcaolQIyZhTsoSZD1CWmWmgLrFt8cnde-HDi674cprg__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA'),(75,'Leo','leo','this is movie','leo');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-28 20:39:18
