import cv2
import easyocr
import preprocessing as prep
import numpy as np

p = 'ci-recto.png'

def extraction(path_image):
    image = cv2.imread(path_image, 0)
    erosion = prep.erosion(image)
    cv2.imshow('Image', erosion)
    cv2.waitKey()
    cv2.destroyAllWindows()
    reader = easyocr.Reader(['fr'])
    results = reader.readtext(erosion)
    L = list()
    for result in results:
        L.append(prep.prepString(result[1]))
    return L

extraction(p)