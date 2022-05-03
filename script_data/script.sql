USE [master]
GO
/****** Object:  Database [moto_shop]    Script Date: 4/29/2022 9:45:58 PM ******/
CREATE DATABASE [moto_shop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'moto_shop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\moto_shop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'moto_shop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\moto_shop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [moto_shop] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [moto_shop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [moto_shop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [moto_shop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [moto_shop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [moto_shop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [moto_shop] SET ARITHABORT OFF 
GO
ALTER DATABASE [moto_shop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [moto_shop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [moto_shop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [moto_shop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [moto_shop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [moto_shop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [moto_shop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [moto_shop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [moto_shop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [moto_shop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [moto_shop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [moto_shop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [moto_shop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [moto_shop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [moto_shop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [moto_shop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [moto_shop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [moto_shop] SET RECOVERY FULL 
GO
ALTER DATABASE [moto_shop] SET  MULTI_USER 
GO
ALTER DATABASE [moto_shop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [moto_shop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [moto_shop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [moto_shop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [moto_shop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [moto_shop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'moto_shop', N'ON'
GO
ALTER DATABASE [moto_shop] SET QUERY_STORE = OFF
GO
USE [moto_shop]
GO
/****** Object:  Table [dbo].[ChiTietHopDong]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHopDong](
	[maHD] [int] NOT NULL,
	[maXe] [int] NOT NULL,
	[soLuong] [nchar](10) NULL,
 CONSTRAINT [PK_ChiTietHopDong] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDTraGop]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDTraGop](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[maHD] [int] NULL,
	[soLanTra] [int] NULL,
	[ngayTra] [date] NULL,
	[soTienTra] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[maHD] [int] IDENTITY(1,1) NOT NULL,
	[ngayLap] [date] NULL,
	[soTienPhaiThanhToan] [money] NULL,
	[soTienDaThanhToan] [money] NULL,
	[thoiGianBaoHanh] [varchar](100) NULL,
	[maKH] [int] NULL,
	[maNV] [int] NULL,
	[loaiHopDong] [varchar](100) NULL,
 CONSTRAINT [PK_HopDong] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [int] IDENTITY(1,1) NOT NULL,
	[tenKH] [varchar](200) NULL,
	[diaChi] [varchar](500) NULL,
	[soDienThoai] [varchar](100) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LinhKien]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LinhKien](
	[maLinKien] [int] IDENTITY(1,1) NOT NULL,
	[tenLinhKien] [varchar](200) NULL,
	[maPhieu] [int] NULL,
 CONSTRAINT [PK_LinhKien] PRIMARY KEY CLUSTERED 
(
	[maLinKien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiXe]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiXe](
	[maLoai] [int] IDENTITY(1,1) NOT NULL,
	[tenLoai] [varchar](200) NULL,
 CONSTRAINT [PK_LoaiXe] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [int] IDENTITY(1,1) NOT NULL,
	[tenNV] [varchar](200) NULL,
	[chucVu] [varchar](200) NULL,
	[soDienThoai] [varchar](100) NULL,
	[email] [varchar](100) NULL,
	[diaChi] [varchar](500) NULL,
	[gioiTinh] [varchar](100) NULL,
	[role] [varchar](100) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVienHanhChanh]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVienHanhChanh](
	[maNV] [int] NOT NULL,
	[maPhongBan] [int] NULL,
	[trinhDoHocVan] [varchar](200) NULL,
 CONSTRAINT [PK_NhanVienHanhChanh] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVienKyThuat]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVienKyThuat](
	[maNV] [int] NOT NULL,
	[bacTho] [varchar](100) NULL,
	[soNamKinhNghiem] [int] NULL,
 CONSTRAINT [PK_NhanVienKyThuat] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhanXet]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhanXet](
	[maPhieu] [int] IDENTITY(1,1) NOT NULL,
	[liDoBH] [varchar](500) NULL,
	[loiThuocVe] [varchar](100) NULL,
	[giaTien] [money] NULL,
	[maNV] [int] NULL,
	[maKH] [int] NULL,
 CONSTRAINT [PK_PhieuNhanXet] PRIMARY KEY CLUSTERED 
(
	[maPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongBan](
	[maPhongBan] [int] IDENTITY(1,1) NOT NULL,
	[tenPhongBan] [varchar](200) NULL,
 CONSTRAINT [PK_PhongBan] PRIMARY KEY CLUSTERED 
(
	[maPhongBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[maNV] [int] NULL,
	[password] [varchar](100) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XeMay]    Script Date: 4/29/2022 9:45:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XeMay](
	[maXe] [int] IDENTITY(1,1) NOT NULL,
	[tenXe] [varchar](200) NULL,
	[soPK] [int] NULL,
	[mauXe] [varchar](50) NULL,
	[nuocSanXuat] [varchar](100) NULL,
	[dongia] [money] NULL,
	[maLoai] [int] NULL,
	[hinhAnh] [image] NULL,
 CONSTRAINT [PK_XeMay] PRIMARY KEY CLUSTERED 
(
	[maXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHopDong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHopDong_HopDong] FOREIGN KEY([maHD])
REFERENCES [dbo].[HopDong] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHopDong] CHECK CONSTRAINT [FK_ChiTietHopDong_HopDong]
GO
ALTER TABLE [dbo].[ChiTietHopDong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHopDong_XeMay] FOREIGN KEY([maXe])
REFERENCES [dbo].[XeMay] ([maXe])
GO
ALTER TABLE [dbo].[ChiTietHopDong] CHECK CONSTRAINT [FK_ChiTietHopDong_XeMay]
GO
ALTER TABLE [dbo].[HDTraGop]  WITH CHECK ADD  CONSTRAINT [FK_HDTraGop_HopDong] FOREIGN KEY([maHD])
REFERENCES [dbo].[HopDong] ([maHD])
GO
ALTER TABLE [dbo].[HDTraGop] CHECK CONSTRAINT [FK_HDTraGop_HopDong]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [FK_HopDong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [FK_HopDong_KhachHang]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [FK_HopDong_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [FK_HopDong_NhanVien]
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD  CONSTRAINT [FK_LinhKien_PhieuNhanXet] FOREIGN KEY([maPhieu])
REFERENCES [dbo].[PhieuNhanXet] ([maPhieu])
GO
ALTER TABLE [dbo].[LinhKien] CHECK CONSTRAINT [FK_LinhKien_PhieuNhanXet]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_NhanVienHanhChanh] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVienHanhChanh] ([maNV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_NhanVienHanhChanh]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_NhanVienKyThuat] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVienKyThuat] ([maNV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_NhanVienKyThuat]
GO
ALTER TABLE [dbo].[NhanVienHanhChanh]  WITH CHECK ADD  CONSTRAINT [FK_NhanVienHanhChanh_PhongBan] FOREIGN KEY([maPhongBan])
REFERENCES [dbo].[PhongBan] ([maPhongBan])
GO
ALTER TABLE [dbo].[NhanVienHanhChanh] CHECK CONSTRAINT [FK_NhanVienHanhChanh_PhongBan]
GO
ALTER TABLE [dbo].[PhieuNhanXet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhanXet_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[PhieuNhanXet] CHECK CONSTRAINT [FK_PhieuNhanXet_KhachHang]
GO
ALTER TABLE [dbo].[PhieuNhanXet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhanXet_NhanVienKyThuat] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVienKyThuat] ([maNV])
GO
ALTER TABLE [dbo].[PhieuNhanXet] CHECK CONSTRAINT [FK_PhieuNhanXet_NhanVienKyThuat]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[XeMay]  WITH CHECK ADD  CONSTRAINT [FK_XeMay_LoaiXe] FOREIGN KEY([maLoai])
REFERENCES [dbo].[LoaiXe] ([maLoai])
GO
ALTER TABLE [dbo].[XeMay] CHECK CONSTRAINT [FK_XeMay_LoaiXe]
GO
USE [master]
GO
ALTER DATABASE [moto_shop] SET  READ_WRITE 
GO
