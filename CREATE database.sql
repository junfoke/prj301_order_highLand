CREATE TABLE [dbo].[Account](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	username [varchar](255) not NULL,
	[pass] [varchar](255) not NULL,
    [name] [nvarchar](255) not NULL
)

CREATE TABLE [dbo].[Category](
	[cateID] [int] IDENTITY(1,1) primary key,
	[cname] [nvarchar](50) NOT NULL
)

CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) primary key,
	[cateID] [int] references Category(cateID),
	[name] [nvarchar](max) not NULL,
	[size] [nvarchar](max) not NULL,
	[price] [money] NULL
) 

create table [dbo].[Orders](
    [OrderID] [int] IDENTITY(1,1) primary key,
	[Date]	[Date]	,
	[Amount]	[price]
)
create table [dbo].[OrderItems](
    [OrderID]	[int] references Order(OrderID),
	[ProductID]	[int]	(5) references product(id),
	[Quantity]	[int] 	,
	[SellPrice]	[float],
	primary key(OrderID, ProductID) 
)
create table [dbo].[DiscountCode](
    [disCodID] [int] not null,
    [disCod] [varchar](50) not null,
    [disNum] [int] not null
)

SET IDENTITY_INSERT [dbo].[DiscountCode] ON
INSERT [dbo].[DiscountCode] ([disCodID], [disCod],[disNum]) VALUES (1, 'GIAMGIA50', 50)
INSERT [dbo].[DiscountCode] ([disCodID], [disCod],[disNum]) VALUES (2, 'GIAMGIA30', 30)
INSERT [dbo].[DiscountCode] ([disCodID], [disCod],[disNum]) VALUES (3, 'GIAMGIA20', 20)
SET IDENTITY_INSERT [dbo].[Account] OFF


SET IDENTITY_INSERT [dbo].[Account] ON 
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (1, 'alice', '1234', N'Nguyễn Thị Ánh')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (2, 'bob', '5678', N'Trần Văn Bình')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (3, 'charlie', 'abcd', N'Phạm Thị Châu')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (4, 'david', 'efgh', N'Lê Văn Dũng')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (5, 'eve', 'ijkl', N'Nguyễn Thị Em')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (6, 'frank', 'mnop', N'Trần Văn Phúc')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (7, 'grace', 'qrst', N'Phạm Thị Giang')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (8, 'harry', 'uvwx', N'Lê Văn Hùng')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (9, 'irene', 'yzab', N'Nguyễn Thị Ích')
INSERT [dbo].[Account] ([uID], [username], [pass], [name]) VALUES (10, 'james', 'cdef', N'Trần Văn Khoa')
SET IDENTITY_INSERT [dbo].[Account] OFF


SET IDENTITY_INSERT [dbo].[Category] on
INSERT [dbo].[Category] ([cateID], [cname]) VALUES (1, N'Cofee')
INSERT [dbo].[Category] ([cateID], [cname]) VALUES (2, N'Freeze')
INSERT [dbo].[Category] ([cateID], [cname]) VALUES (3, N'TEA')
INSERT [dbo].[Category] ([cateID], [cname]) VALUES (4, N'JUICE')
INSERT [dbo].[Category] ([cateID], [cname]) VALUES (5, N'CAKE')
INSERT [dbo].[Category] ([cateID], [cname]) VALUES (6, N'TEA&MILK')
SET IDENTITY_INSERT [dbo].[Category] OFF

SET IDENTITY_INSERT [dbo].[product] ON 
-- ct1-sp1
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (1, 1, 'Espresso','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (2, 1, 'Espresso','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (3, 1, 'Espresso','L',45.000)
-- ct1-sp2 
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (4, 1, 'Cappuccino','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (5, 1, 'Cappuccino','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (6, 1, 'Cappuccino','L',45.000)
-- ct1-sp3 
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (7, 1, 'Cafe Latte','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (8, 1, 'Cafe Latte','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (9, 1, 'Cafe Latte','L',45.000)
-- ct1-sp4
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (10, 1, 'Latte Macchiato','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (11, 1, 'Latte Macchiato','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (12, 1, 'Latte Macchiato','L',45.000)
-- ct1-sp5
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (13, 1, 'Americano','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (14, 1, 'Americano','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (15, 1, 'Americano','L',45.000)
-- ct1-sp6 
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (16, 1, 'Espresso Con Panna','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (17, 1, 'Espresso Con Panna','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (18, 1, 'Espresso Con Panna','L',45.000)


-- ct2-sp1
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (19, 2, 'Freeze socola','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (20, 2, 'Freeze socola','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (21, 2, 'Freeze socola','L',45.000)
-- ct2-sp2
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (22, 2, 'Freeze Tra Xanh','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (23, 2, 'Freeze Tra Xanh','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (24, 2, 'Freeze Tra Xanh','L',45.000)
-- ct2-sp32, 
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (25, 2, 'Cookie&Cream','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (26, 2, 'Cookie&Cream','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (27, 2, 'Cookie&Cream','L',45.000)
-- ct2-sp42, 
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (28, 2, 'CARAMEL PHIN FREEZE','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (29, 2, 'CARAMEL PHIN FREEZE','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (30, 2, 'CARAMEL PHIN FREEZE','L',45.000)
-- ct2-sp52, 
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (31, 2, 'CLASSIC PHIN FREEZE','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (32, 2, 'CLASSIC PHIN FREEZE','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (33, 2, 'CLASSIC PHIN FREEZE','L',45.000)
-- ct2-sp62, 
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (34, 2, 'FREEZE new','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (35, 2, 'FREEZE new','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (36, 2, 'FREEZE new','L',45.000)

-- ct3-sp1
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (37, 3, 'Tra Thach Dao','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (38,3, 'Tra Thach Dao','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (39, 3, 'Tra Thach Dao','L',45.000)
-- ct3-sp2
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (40, 3, 'Tra Sen Vang','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (41, 3, 'Tra Sen Vang','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (42, 3, 'Tra Sen vang','L',45.000)
-- ct3-sp3
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (43, 3, 'Tra Chanh','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (44, 3, 'Tra Chanh','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (45, 3, 'Tra Chanh','L',45.000)
-- ct3-sp4
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (46, 3, 'Tra Thach Vai','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (47, 3, 'Tra Thach Vai','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (48, 3, 'Tra Thach Vai','L',45.000)
-- ct3-sp5
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (49, 3, 'Tra Duong Sinh','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (50, 3, 'Tra Duong Sinh','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (51, 3, 'Tra Duong Sinh','L',45.000)
-- ct3-sp6
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (52, 3, 'Tra Hoa Cuc','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (53, 3, 'Tra Hoa Cuc','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (54, 3, 'Tra Hoa Cuc','L',45.000)


-- ct4-sp1
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (55, 4, 'JUICE CAM','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (56, 4, 'JUICE CAM','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (57, 4, 'JUICE CAM','L',45.000)
-- ct4-sp2
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (58, 4, 'JUICE TAO','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (59, 4, 'JUICE TAO','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (60, 4, 'JUICE TAO','L',45.000)
-- ct4-sp3
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (61, 4, 'Smoothie','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (62, 4, 'Smoothie','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (63, 4, 'Smoothie','L',45.000)
-- ct4-sp4
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (64, 4, 'JUICE Mix','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (65, 4, 'JUICE Mix','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (66, 4, 'JUICE Mix','L',45.000)
-- ct4-sp5
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (67, 4, 'Green Juice','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (68, 4, 'Green Juice','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (69, 4, 'Green Juice','L',45.000)
-- ct4-sp6
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (70, 4, 'JUICE DUA','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (71, 4, 'JUICE DUA','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (72, 4, 'JUICE DUA','L',45.000)


-- ct5-sp1
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (73, 5, 'Mille Feuille','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (74, 5, 'Mille Feuille','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (75, 5, 'Mille Feuille','L',45.000) 
-- ct5-sp2
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (76, 5, 'Fraisier','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (77, 5, 'Fraisier','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (78, 5, 'Fraisier','L',45.000) 
-- ct5-sp3
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (79, 5, 'Charlotte Russe','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (80, 5, 'Charlotte Russe','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (81, 5, 'Charlotte Russe','L',45.000) 
-- ct5-sp4
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (82, 5, 'baba au rhum','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (83, 5, 'baba au rhum','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (84, 5, 'baba au rhum','L',45.000) 
-- ct5-sp5
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (85, 5, 'dacoiser','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (86, 5, 'dacoiser','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (87, 5, 'dacoiser','L',45.000) 
-- ct5-sp6
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (88, 5, 'Banh Mi','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (89, 5, 'Banh Mi','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (90, 5, 'Banh Mi','L',45.000)  


-- ct6-sp1
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (91, 6, 'TS matcha','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (92, 6, 'TS matcha','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (93, 6, 'TS matcha','L',45.000)
-- ct6-sp2
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (94, 6, 'TS socola','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (95, 6, 'TS socola','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (96, 6, 'TS socola','L',45.000)
-- ct6-sp3
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (97, 6, 'TS bac ha','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (98, 6, 'TS bac ha','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (99, 6, 'TS bac ha','L',45.000)
-- ct6-sp4
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (100, 6, 'TS oreo','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (101, 6, 'TS oreo','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (102, 6, 'TS oreo','L',45.000)
-- ct6-sp5
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (103, 6, 'TS Khoai Mon','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (104, 6, 'TS Khoai Mon','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (105, 6, 'TS Khoai Mon','L',45.000)
-- ct6-sp6
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (106, 6, 'TS Duong Nau','S',35.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (107, 6, 'TS Duong Nau','M',40.000)
INSERT [dbo].[product] ([id], [cateID], [name], [size], [price]) VALUES (108, 6, 'TS Duong Nau','L',45.000)
SET IDENTITY_INSERT [dbo].[product] OFF 

