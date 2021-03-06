USE [master]
GO
/****** Object:  Database [FarmProductDB5]    Script Date: 2021/1/13 22:23:48 ******/
CREATE DATABASE [FarmProductDB5]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FarmProductDB5', FILENAME = N'D:\AMyWorld\programme\MyPrograme\数据库\数据库文件\FarmProductDB5.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'FarmProductDB5_log', FILENAME = N'D:\AMyWorld\programme\MyPrograme\数据库\数据库文件\FarmProductDB5_log.ldf' , SIZE = 1088KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [FarmProductDB5] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FarmProductDB5].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FarmProductDB5] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FarmProductDB5] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FarmProductDB5] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FarmProductDB5] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FarmProductDB5] SET ARITHABORT OFF 
GO
ALTER DATABASE [FarmProductDB5] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [FarmProductDB5] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FarmProductDB5] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FarmProductDB5] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FarmProductDB5] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FarmProductDB5] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FarmProductDB5] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FarmProductDB5] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FarmProductDB5] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FarmProductDB5] SET  ENABLE_BROKER 
GO
ALTER DATABASE [FarmProductDB5] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FarmProductDB5] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FarmProductDB5] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FarmProductDB5] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FarmProductDB5] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FarmProductDB5] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FarmProductDB5] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FarmProductDB5] SET RECOVERY FULL 
GO
ALTER DATABASE [FarmProductDB5] SET  MULTI_USER 
GO
ALTER DATABASE [FarmProductDB5] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FarmProductDB5] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FarmProductDB5] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FarmProductDB5] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [FarmProductDB5] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'FarmProductDB5', N'ON'
GO
USE [FarmProductDB5]
GO
/****** Object:  Table [dbo].[Address]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Address](
	[addressID] [int] IDENTITY(1,1) NOT NULL,
	[userID] [int] NOT NULL,
	[addressInfo] [varchar](40) NOT NULL,
	[phone] [varchar](40) NOT NULL,
	[name] [varchar](40) NOT NULL,
	[judge] [int] NOT NULL DEFAULT ((1)),
PRIMARY KEY CLUSTERED 
(
	[addressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[admin]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[admin](
	[adminID] [varchar](40) NOT NULL,
	[adminAccount] [varchar](40) NOT NULL,
	[password] [varchar](40) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Attribute]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Attribute](
	[attributeID] [int] IDENTITY(1,1) NOT NULL,
	[attributeName] [varchar](40) NOT NULL,
	[categoryID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[attributeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AttributeValue]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AttributeValue](
	[attributeValueID] [int] IDENTITY(1,1) NOT NULL,
	[value] [varchar](40) NULL CONSTRAINT [DF_AttributeValue_value]  DEFAULT (NULL),
	[attributeID] [int] NOT NULL,
	[productID] [int] NOT NULL,
 CONSTRAINT [PK__Attribut__A974A7F1BE4882AF] PRIMARY KEY CLUSTERED 
(
	[attributeValueID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Category]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [varchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[CategoryName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[CategoryName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Collect]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Collect](
	[productID] [int] NOT NULL,
	[userID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC,
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Evaluation]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Evaluation](
	[evaluationID] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](200) NOT NULL,
	[evaluationDate] [datetime] NOT NULL,
	[userID] [int] NOT NULL,
	[productID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[evaluationID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Genetration]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Genetration](
	[userID] [int] NOT NULL,
	[orderID] [int] NOT NULL,
	[orderStatus] [varchar](40) NOT NULL,
	[buyOrSale] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC,
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Order]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[orderID] [int] IDENTITY(1,1) NOT NULL,
	[orderMoney] [money] NOT NULL,
	[geneTime] [datetime] NOT NULL,
	[quantity] [int] NOT NULL,
	[productID] [int] NOT NULL,
	[addressID] [int] NOT NULL,
 CONSTRAINT [PK__Order__0809337D8AF07B6E] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Picture]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Picture](
	[PictureID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NOT NULL,
	[Pictureaddress] [varchar](40) NOT NULL,
 CONSTRAINT [PK__Picture__8C2866F8D470A5B4] PRIMARY KEY CLUSTERED 
(
	[PictureID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[productID] [int] IDENTITY(1,1) NOT NULL,
	[productName] [varchar](40) NOT NULL,
	[title] [varchar](255) NOT NULL,
	[unitPrice] [money] NOT NULL,
	[stock] [int] NULL,
	[updateDate] [datetime] NOT NULL,
	[launchDate] [datetime] NOT NULL,
	[categoryID] [int] NOT NULL,
	[specification] [varchar](40) NOT NULL,
	[UserID] [int] NULL,
 CONSTRAINT [PK__Product__2D10D14AEA126DE1] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[userID] [int] IDENTITY(1,1) NOT NULL,
	[userName] [varchar](40) NOT NULL,
	[Email] [varchar](40) NOT NULL,
	[userPhone] [varchar](40) NOT NULL,
	[password] [varchar](40) NOT NULL,
	[userphoto] [varchar](40) NULL CONSTRAINT [DF_Users_userphoto]  DEFAULT (NULL),
	[businessType] [int] NULL CONSTRAINT [DF__Users__businessT__29572725]  DEFAULT (NULL),
	[ownerName] [varchar](40) NULL CONSTRAINT [DF_Users_ownerName]  DEFAULT (NULL),
	[businessName] [varchar](40) NULL CONSTRAINT [DF__Users__businessN__2A4B4B5E]  DEFAULT (NULL),
	[businessAddress] [varchar](40) NULL CONSTRAINT [DF__Users__businessA__2B3F6F97]  DEFAULT (NULL),
	[businessphone] [varchar](40) NULL CONSTRAINT [DF__Users__businessp__2C3393D0]  DEFAULT (NULL),
 CONSTRAINT [PK__Users__CB9A1CDF9F3CBAB3] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ__Users__66DCF95C07C0916A] UNIQUE NONCLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ__Users__66DCF95CD7F5A774] UNIQUE NONCLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[orderInfo]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create view [dbo].[orderInfo] as
select a.orderID,a.quantity,d.unitPrice,a.orderMoney,a.geneTime,a.productID,b.orderStatus,c.addressInfo,c.phone,c.name
	from [Order] a, [Genetration] b, [Address] c, [Product] d 
	where a.orderID = b.orderID and a.addressID = c.addressID and a.productID = d.productID


GO
/****** Object:  View [dbo].[ProductInfo]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[ProductInfo]
AS
SELECT  a.productID, a.productName, a.title, c.Pictureaddress, a.unitPrice, a.stock, a.updateDate, a.launchDate, b.CategoryName, 
                   a.specification, a.UserID, d.userPhone
FROM      dbo.Product AS a INNER JOIN
                   dbo.Category AS b ON a.categoryID = b.CategoryID INNER JOIN
                       (SELECT  ProductID, Pictureaddress
                        FROM       dbo.Picture
                        WHERE    (PictureID IN
                                               (SELECT  MIN(PictureID) AS PictureID
                                                FROM       dbo.Picture
                                                GROUP BY ProductID))) AS c ON a.productID = c.ProductID INNER JOIN
                   dbo.Users AS d ON a.UserID = d.userID


GO
/****** Object:  View [dbo].[shopInfo]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[shopInfo] as

	select a.userID, b.CategoryName, a.ownerName, a.businessName, a.businessAddress, a.businessphone, a.userPhone from [Users] a, [Category] b where a.businessType = b.CategoryID

GO
/****** Object:  View [dbo].[userInfo]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[userInfo] as
	
	select a.userID, a.userName, a.Email, a.userPhone, a.[password] from [Users] a

GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Picture]    Script Date: 2021/1/13 22:23:48 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Picture] ON [dbo].[Picture]
(
	[Pictureaddress] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [FK__Address__userID__2D27B809] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [FK__Address__userID__2D27B809]
GO
ALTER TABLE [dbo].[Attribute]  WITH CHECK ADD FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([CategoryID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[AttributeValue]  WITH CHECK ADD  CONSTRAINT [FK__Attribute__attri__300424B4] FOREIGN KEY([attributeID])
REFERENCES [dbo].[Attribute] ([attributeID])
GO
ALTER TABLE [dbo].[AttributeValue] CHECK CONSTRAINT [FK__Attribute__attri__300424B4]
GO
ALTER TABLE [dbo].[AttributeValue]  WITH CHECK ADD  CONSTRAINT [FK__Attribute__attri__30F848ED] FOREIGN KEY([attributeID])
REFERENCES [dbo].[Attribute] ([attributeID])
GO
ALTER TABLE [dbo].[AttributeValue] CHECK CONSTRAINT [FK__Attribute__attri__30F848ED]
GO
ALTER TABLE [dbo].[AttributeValue]  WITH CHECK ADD  CONSTRAINT [FK__Attribute__produ__300424B4] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([productID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[AttributeValue] CHECK CONSTRAINT [FK__Attribute__produ__300424B4]
GO
ALTER TABLE [dbo].[Collect]  WITH CHECK ADD  CONSTRAINT [FK__Collect__product__30F848ED] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([productID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Collect] CHECK CONSTRAINT [FK__Collect__product__30F848ED]
GO
ALTER TABLE [dbo].[Collect]  WITH CHECK ADD  CONSTRAINT [FK__Collect__userID__31EC6D26] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Collect] CHECK CONSTRAINT [FK__Collect__userID__31EC6D26]
GO
ALTER TABLE [dbo].[Evaluation]  WITH CHECK ADD  CONSTRAINT [FK__Evaluatio__produ__32E0915F] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([productID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Evaluation] CHECK CONSTRAINT [FK__Evaluatio__produ__32E0915F]
GO
ALTER TABLE [dbo].[Evaluation]  WITH CHECK ADD  CONSTRAINT [FK__Evaluatio__userI__33D4B598] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Evaluation] CHECK CONSTRAINT [FK__Evaluatio__userI__33D4B598]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK__Order__serialNum__34C8D9D1] FOREIGN KEY([addressID])
REFERENCES [dbo].[Address] ([addressID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK__Order__serialNum__34C8D9D1]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK__Order__serialNum__6E01572D] FOREIGN KEY([addressID])
REFERENCES [dbo].[Address] ([addressID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK__Order__serialNum__6E01572D]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([productID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Product]
GO
ALTER TABLE [dbo].[Picture]  WITH CHECK ADD  CONSTRAINT [FK__Picture__Product__36B12243] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([productID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Picture] CHECK CONSTRAINT [FK__Picture__Product__36B12243]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK__Product__categor__37A5467C] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([CategoryID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK__Product__categor__37A5467C]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Users] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([userID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Users]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Category] FOREIGN KEY([businessType])
REFERENCES [dbo].[Category] ([CategoryID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Category]
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD CHECK  (([judge]=(1) OR [judge]=(0)))
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD CHECK  (([judge]=(1) OR [judge]=(0)))
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD CHECK  (([phone] like '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD CHECK  (([phone] like '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' OR [phone] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
GO
ALTER TABLE [dbo].[Genetration]  WITH CHECK ADD CHECK  (([buyOrSale]='卖' OR [buyOrSale]='买'))
GO
ALTER TABLE [dbo].[Genetration]  WITH CHECK ADD CHECK  (([buyOrSale]='卖' OR [buyOrSale]='买'))
GO
ALTER TABLE [dbo].[Genetration]  WITH CHECK ADD CHECK  (([orderStatus]='已收货' OR [orderStatus]='运输中' OR [orderStatus]='待处理'))
GO
ALTER TABLE [dbo].[Genetration]  WITH CHECK ADD CHECK  (([orderStatus]='已收货' OR [orderStatus]='运输中' OR [orderStatus]='待处理'))
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK__Product__stock__3D5E1FD2] CHECK  (([stock]>=(0)))
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK__Product__stock__3D5E1FD2]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK__Product__stock__75A278F5] CHECK  (([stock]>=(0)))
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK__Product__stock__75A278F5]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK__Product__unitPri__3E52440B] CHECK  (([unitPrice]>=(0)))
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK__Product__unitPri__3E52440B]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK__Product__unitPri__76969D2E] CHECK  (([unitPrice]>=(0)))
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK__Product__unitPri__76969D2E]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [CK__Users__password__3F466844] CHECK  ((len([password])>=(6) AND len([password])<=(18)))
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [CK__Users__password__3F466844]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [CK__Users__password__778AC167] CHECK  ((len([password])>=(6) AND len([password])<=(18)))
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [CK__Users__password__778AC167]
GO
/****** Object:  StoredProcedure [dbo].[cate_add]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[cate_add](
	@cate_name varchar(40)
)
as
declare @re int 
set @re = 0
insert into Category  (CategoryName) values (@cate_name) 
set @re = 1
return @re

GO
/****** Object:  StoredProcedure [dbo].[cate_update]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[cate_update](
	@cate_id int,
	@cate_name varchar(40)
)
as
declare @re int 
set @re=0
update Category set CategoryName = @cate_name where CategoryID = @cate_id
set @re=1 
return @re
GO
/****** Object:  StoredProcedure [dbo].[order_del]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[order_del](
	@order_id int
)
as 
declare @re int
set @re = 0
begin tran
	delete from [Order] where [orderID] = @order_id
	delete from [Genetration] where [orderID] = @order_id
	set @re = 1
commit tran
	return @re

GO
/****** Object:  StoredProcedure [dbo].[pro_del]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--产品删除
CREATE procedure [dbo].[pro_del]
@pro_id int
as
declare @re int
set @re = 0
begin tran
	delete from [Picture] where ProductID = @pro_id
	declare @order_id int
	select @order_id = (select orderID from [Order] where productID = @pro_id)
 
	declare @pp int
	execute @pp = [order_del] @order_id
	if @pp = 1
		begin 
			delete from [Order] where productID = @pro_id
			delete from [Evaluation] where productID = @pro_id
			delete from [Collect] where productID = @pro_id
			delete from [AttributeValue] where productID = @pro_id
			delete from [Product] where productID = @pro_id
			set @re = 1
		end
	else
		begin
			rollback tran
			return @re
		end
commit tran
	return @re

GO
/****** Object:  StoredProcedure [dbo].[shop_del]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE procedure [dbo].[shop_del](
	@shop_id int
)
as 

declare @re int
set @re = 0
begin tran
	--定义产品id 作为参数
	declare @pro_id int
	--定义游标
	declare shop_del_cur cursor for
		select productID from Product where UserID = @shop_id
	open shop_del_cur
	fetch shop_del_cur into @pro_id
	--定义返回变量@pp
	declare @pp int
	while(@@FETCH_STATUS = 0)
	begin		
		execute @pp = pro_del @pro_id
		if @pp = 0
		begin
			rollback tran
			return @re
		end
		fetch shop_del_cur into @pro_id
	end
	update Users set businessType = null, ownerName = null, businessName = null, businessAddress = null,businessphone = null
		where userID = @shop_id
	-- 返回参数置1，说明删除成功
	set @re = 1
commit tran
	return @re

GO
/****** Object:  StoredProcedure [dbo].[shop_update]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE procedure [dbo].[shop_update](
	@shop_id int,
	@categoryName varchar(40),
	@ownerName varchar(40),
	@busName varchar(40),
	@busAddress varchar(40),
	@busPhone varchar(40),
	@userPhone varchar(40)
)
as

declare @re int
set @re = 0
begin tran
	declare @cate_id int
	if exists(select CategoryID from Category where CategoryName = @categoryName)
		begin
			select @cate_id = (select CategoryID from Category where CategoryName = @categoryName)
		end
	else
		begin
			rollback tran
			return @re
		end 
	--执行更新操作
	update Users set businessType = @cate_id, ownerName = @ownerName, businessName = @busName, 
		businessAddress = @busAddress, businessphone = @busPhone, userPhone = @userPhone 
		where userID = @shop_id
	set @re = 1
commit tran
	return @re
GO
/****** Object:  StoredProcedure [dbo].[user_add]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--用户注册
CREATE procedure [dbo].[user_add](
	@name varchar(40),
	@email varchar(40),
	@userPhone varchar(40),
	@pass varchar(40)
)
as

declare @re int
set @re = 0
insert into Users (userName,Email,userPhone,[password]) values (@name, @email, @userPhone, @pass)
set @re = 1
return @re

GO
/****** Object:  StoredProcedure [dbo].[user_del]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE procedure [dbo].[user_del](
	@user_id int
)
as 

declare @re int
set @re = 0
begin tran
	delete from Address where userID = @user_id

	--定义产品id 作为参数
	declare @pro_id int
	--定义游标
	declare user_del_cur cursor for
		select productID from Product where UserID = @user_id
	--打开游标
	open user_del_cur
	--获取游标值
	fetch user_del_cur into @pro_id
	--定义返回变量@pp
	declare @pp int
	while(@@FETCH_STATUS = 0)
	begin		
		execute @pp = pro_del @pro_id
		if @pp = 0
		begin
			rollback tran
			return @re
		end
		fetch user_del_cur into @pro_id
	end

	delete from Users where userID = @user_id
	-- 返回参数置1，说明删除成功
	set @re = 1
	 
commit tran
	return @re

GO
/****** Object:  StoredProcedure [dbo].[user_update]    Script Date: 2021/1/13 22:23:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE procedure [dbo].[user_update](
	@userID int,
	@userName varchar(40),
	@Email varchar(40),
	@userPhone varchar(40),
	@password varchar(40)
)
as

declare @re int
set @re = 0
update Users set userName = @userName, Email = @Email, userPhone = @userPhone, [password] = @password 
	where userID = @userID
set @re = 1
return @re

 
 

	


GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "a"
            Begin Extent = 
               Top = 7
               Left = 48
               Bottom = 170
               Right = 245
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "b"
            Begin Extent = 
               Top = 175
               Left = 48
               Bottom = 294
               Right = 253
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "c"
            Begin Extent = 
               Top = 294
               Left = 48
               Bottom = 413
               Right = 251
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "d"
            Begin Extent = 
               Top = 413
               Left = 48
               Bottom = 576
               Right = 265
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'ProductInfo'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'ProductInfo'
GO
USE [master]
GO
ALTER DATABASE [FarmProductDB5] SET  READ_WRITE 
GO
