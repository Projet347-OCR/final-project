import easyocr
import cv2
import numpy as np
import preprocessing as prep
import json


# # initialisation
# L = list()
# path1 = "ci1-recto.png"
# path2 = "ci1-verso.png"
#
# # Lecture de l'image comme un numpy
# imager = cv2.imread(path1)
# imagev = cv2.imread(path2)
# print(imagev)
# print(imager)
#
# # binarisation
# imgr = cv2.bitwise_not(imager)
# imgv = cv2.bitwise_not(imagev)
#
# # declaration du moteur OCR
# reader = easyocr.Reader(['en', 'fr'])
#
# # reconnaissance des chaines de caractère
# resultsr = reader.readtext(imgr)
# resultsv= reader.readtext(imgv)
#
#
# for result in resultsr:
#     L.append(prep.prepString(result[1]))
#
# for result in resultsv:
#     L.append(prep.prepString(result[1]))
#
# # affichage de la liste
# print(L)

# path1 = "ci1-recto.png"
# path2 = "ci1-verso.png"
#
# image = cv2.imread(path1, 0)
# img = cv2.bitwise_not(image)
# cv2.imshow("Image binarisee", img)
# thresh, im_bw = cv2.threshold(img, 105, 255, cv2.THRESH_BINARY)
# kernel = np.ones((1, 1), np.uint8)
# erosion = cv2.erode(im_bw, kernel, iterations=1)
# cv2.imshow("Erosion", erosion)
# cv2.waitKey(0)
# cv2.destroyAllWindows()


# ----------------------------------
#
# for l in L:
#     if 'CARTE' in l:
#         my_dico['TYPE DE PIECE'] = l
#     if 'FR' in l:
#         my_dico['PAYS'] = 'FRANCE'
#     if 'NOM' in l:
#         #if l in french et l+1=ang, prendre l+2 else l+1
#         my_dico[l] = ''
#     if 'PRENOM' in l:
#         my_dico[l] = ''
#     if 'DATE DE NAISS' in l:
#         my_dico[l] = ''
#     if 'LIEU DE NAISSANCE' in l:
#         my_dico[l] = ''
#     if 'NATIONALITÉ' in l:
#         my_dico[l] = ''
#     if 'SEXE' in l:
#         my_dico[l] = ''
#     if 'TAILLE' in l:
#         my_dico[l] = ''
#     if 'ADRESSE' in l:
#         my_dico[l] = ''
#     if 'N DU DOCUMENT' in l:
#         my_dico[l] = ''
#     if 'DATE DEXPIR' in l:
#         my_dico[l] = ''
#     if 'DATE DE DÉLIVRANCE' in l:
#         my_dico[l] = ''


fileObject = open('data.json', 'r')
jsonContent = fileObject.read()
obj_python = json.loads(jsonContent)
print(obj_python['PRÉNOMS'])