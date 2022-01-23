import re

import cv2
import numpy as np
from scipy.interpolate import UnivariateSpline
from scipy.constants import value


def grayscale(path_image):
    image = cv2.imread(path_image, 0)
    return cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)


def erosion(image):
    thresh, im_bw = cv2.threshold(image, 105, 255, cv2.THRESH_BINARY)
    kernel = np.ones((1, 1), np.uint8)
    erosion = cv2.erode(im_bw, kernel, iterations=1)

    return erosion


def binarization(path_image):
    image = cv2.imread(path_image, 0)
    img = cv2.bitwise_not(image)
    gray_img = grayscale(img)

    thresh, im_bw = cv2.threshold(gray_img, 105, 255, cv2.THRESH_BINARY)

    kernel = np.ones((1, 1), np.uint8)
    erosion = cv2.erode(im_bw, kernel, iterations=1)

    return erosion, im_bw, img, gray_img


def blurred_image(path_image):
    image = cv2.imread(path_image, 0)
    Gaussian = cv2.GaussianBlur(image, (1, 1), 1)
    median = cv2.medianBlur(image, 1)
    bilateral = cv2.bilateralFilter(image, 9, 75, 75)
    kernel = np.array([[-1, -1, -1], [-1, 9, -1], [-1, -1, -1]])
    sharpened = cv2.filter2D(image, -1, kernel)

    return sharpened, bilateral, median, Gaussian


def luminosite(path_image):
    img = cv2.imread(path_image, 0)
    cols, rows, npp = img.shape
    brightness = np.sum(img) / (255 * cols * rows)
    minimum_brightness = 0.66
    alpha = brightness / minimum_brightness
    bright_img = cv2.convertScaleAbs(img, alpha=alpha, beta=255 * (1 - alpha))
    bright_img11 = cv2.convertScaleAbs(img, alpha=1, beta=128)
    bright_img1 = cv2.convertScaleAbs(img, alpha=1, beta=255 * (minimum_brightness - brightness))

    return bright_img, bright_img1, bright_img11


def noise_removal(path_image):
    image = cv2.imread(path_image, 0)
    kernel = np.ones((1, 1), np.uint8)
    image = cv2.dilate(image, kernel, iterations=1)
    kernel = np.ones((1, 1), np.uint8)
    image = cv2.erode(image, kernel, iterations=1)
    kernel = np.ones((1, 1), np.uint8)
    image = cv2.morphologyEx(image, cv2.MORPH_CLOSE, kernel)
    image = cv2.medianBlur(image, 1)

    return image


def sharpened_image(path_image):
    image = cv2.imread(path_image, 0)
    kernel = np.array([[-1, -1, -1],
                       [-1, 9, -1],
                       [-1, -1, -1]])
    sharpened = cv2.filter2D(image, -1, kernel)  # applying the sharpening kernel to the input image & displaying it.

    image1 = cv2.imread(path_image)
    image1 = cv2.cvtColor(image1, cv2.COLOR_BGR2GRAY)
    se = cv2.getStructuringElement(cv2.MORPH_RECT, (8, 8))
    bg = cv2.morphologyEx(image1, cv2.MORPH_DILATE, se)
    out_gray = cv2.divide(image1, bg, scale=255)
    out_binary = cv2.threshold(out_gray, 0, 255, cv2.THRESH_OTSU)[1]

    return out_gray, out_binary, sharpened


def prepString(_str, noise=True, multiplespaces=True):
    noise_list = [".", "?", "!", ";", ")", "~", "(", "{", "}", "@", "$", "*", "[", "]", "\"", "%", "_", '#']
    # remove noise (punctuation) if asked (by default yes)
    if noise:
        for n in noise_list:
            _str = _str.replace(n, "")
    # replace multiple spaces by ine in string if requested (default yes)
    if multiplespaces:
        _str = re.sub(r"\s+", " ", _str).strip()
    # s1 = unicodedata(_str, 'utf-8')
    # s2 = unicodedata.normalize('NFD', s1).encode('ascii', 'ignore')
    return _str.strip().upper()


