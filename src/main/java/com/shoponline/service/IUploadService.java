package com.shoponline.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

	File save(MultipartFile file, String folder);
}
