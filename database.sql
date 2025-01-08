CREATE TABLE Menu (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(255) NOT NULL,        
    parent_id INT DEFAULT NULL,        
    FOREIGN KEY (parent_id) REFERENCES Menu(id) 
);

ALTER TABLE Menu 
ADD COLUMN type VARCHAR(50) NOT NULL DEFAULT 'Khu vực', 
ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

UPDATE Menu
SET 
    type = 'Thành Phố', 
    created_at = CURRENT_TIMESTAMP, 
    updated_at = CURRENT_TIMESTAMP
WHERE parent_id IS NULL;  

UPDATE Menu
SET 
    type = 'Huyện', 
    created_at = CURRENT_TIMESTAMP, 
    updated_at = CURRENT_TIMESTAMP
WHERE parent_id IS NOT NULL AND parent_id <= 4;  

UPDATE Menu
SET 
    type = 'Xã', 
    created_at = CURRENT_TIMESTAMP, 
    updated_at = CURRENT_TIMESTAMP
WHERE parent_id > 4 AND parent_id <= 12;  

UPDATE Menu
SET 
    type = 'Thôn/Khu phố', 
    created_at = CURRENT_TIMESTAMP, 
    updated_at = CURRENT_TIMESTAMP
WHERE parent_id > 12; 

-- Tạo các tỉnh
INSERT INTO Menu (name, parent_id) VALUES 
('Hà Nội', NULL),
('Hải Dương', NULL),
('Thanh Hóa', NULL),
('Sài Gòn', NULL);

-- Tạo các huyện
INSERT INTO Menu (name, parent_id) VALUES 
('Huyện Hoàng Mai', 1), -- Hà Nội
('Huyện Gia Lâm', 1), -- Hà Nội
('Huyện Tứ Kỳ', 2), -- Hải Dương
('Huyện Nam Sách', 2), -- Hải Dương
('Huyện Hoằng Hóa', 3), -- Thanh Hóa
('Huyện Quảng Xương', 3), -- Thanh Hóa
('Quận 1', 4), -- Sài Gòn
('Quận Gò Vấp', 4); -- Sài Gòn

-- Tạo các xã
INSERT INTO Menu (name, parent_id) VALUES 
('Xã Lĩnh Nam', 5), -- Huyện Hoàng Mai
('Xã Trâu Quỳ', 6), -- Huyện Gia Lâm
('Xã Cộng Lạc', 7), -- Huyện Tứ Kỳ
('Xã Minh Tân', 8), -- Huyện Nam Sách
('Xã Hoằng Lý', 9), -- Huyện Hoằng Hóa
('Xã Quảng Lộc', 10), -- Huyện Quảng Xương
('Phường Bến Nghé', 11), -- Quận 1
('Phường 15', 12); -- Quận Gò Vấp

-- Tạo các thôn
INSERT INTO Menu (name, parent_id) VALUES 
('Thôn Trung Tâm', 13), -- Xã Lĩnh Nam
('Thôn Đồng', 14), -- Xã Trâu Quỳ
('Thôn Đoài', 15), -- Xã Cộng Lạc
('Thôn Đông', 16), -- Xã Minh Tân
('Thôn Lý Tân', 17), -- Xã Hoằng Lý
('Thôn Nam Thắng', 18), -- Xã Quảng Lộc
('Khu dân cư số 1', 19), -- Phường Bến Nghé
('Khu phố 4', 20); -- Phường 15

-- Thêm dữ liệu khu vực quanh Hà Nội
INSERT INTO Menu (name, parent_id) VALUES 
('Huyện Đông Anh', 1),
('Huyện Sóc Sơn', 1),
('Xã Kim Chung', 21),
('Xã Nam Hồng', 21),
('Xã Tiên Dược', 22),
('Thôn Xuân Lai', 23),
('Thôn Đa Hội', 24);

-- Thêm dữ liệu khu vực quanh Hải Dương
INSERT INTO Menu (name, parent_id) VALUES 
('Huyện Bình Giang', 2),
('Huyện Thanh Miện', 2),
('Xã Tân Hồng', 25),
('Xã Hồng Phong', 25),
('Xã Lam Sơn', 26),
('Thôn Đông Mai', 27),
('Thôn Ngọc Sơn', 28);

-- Thêm dữ liệu khu vực quanh Thanh Hóa
INSERT INTO Menu (name, parent_id) VALUES 
('Huyện Như Thanh', 3),
('Huyện Triệu Sơn', 3),
('Xã Xuân Khang', 29),
('Xã Minh Sơn', 29),
('Xã Dân Lực', 30),
('Thôn Đồng Bàn', 31),
('Thôn Yên Phú', 32);

-- Thêm dữ liệu khu vực quanh Sài Gòn
INSERT INTO Menu (name, parent_id) VALUES 
('Quận 3', 4),
('Quận Thủ Đức', 4),
('Phường 7', 33),
('Phường Bình Thọ', 34),
('Khu dân cư số 5', 35),
('Khu phố 9', 36);
