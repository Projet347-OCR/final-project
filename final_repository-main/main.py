import extract_data as extract
import json

from flask import Flask,abort,jsonify,request
from flask_cors import CORS, cross_origin

# L = extract.extraction('ci1-recto.png')
# L += extract.extraction('ci1-verso.png')


app = Flask(__name__)
CORS(app, support_credentials=True)


@app.route('/api',methods=['GET'])
@cross_origin(supports_credentials=True)
#def recognition_after_extraction(path):
def recognition_after_extraction():
    path=request.args.get("path")
    L = list()
    L = extract.extraction(path)
    my_dico = {}

    for i in range(0, len(L) - 1):
        if 'CARTE' in L[i]:
            my_dico['TYPE DE PIECE'] = L[i]
        if 'FR' in L[i]:
            my_dico['PAYS'] = 'FRANCE'

        if 'NOM' in L[i] and 'DUSAGE' not in L[i] and 'D\'USAGE' not in L[i + 1]:
            my_dico[L[i]] = L[i + 2]
        if 'PRENOM' in L[i]:
            my_dico[L[i]] = L[i + 2]
        if 'DATE DE NAISS' in L[i]:
            my_dico[L[i]] = L[i + 4]
        if 'LIEU DE NAISSANCE' in L[i]:
            if 'PLACE OF BIRTH' in L[i + 1]:
                my_dico[L[i]] = L[i + 3]
            else:
                my_dico[L[i]] = L[i + 2]
        if 'NATIONALITÉ' in L[i]:
            my_dico[L[i]] = L[i + 5]
        if 'SEXE' in L[i]:
            my_dico[L[i]] = L[i + 6]
        if 'TAILLE' in L[i]:
            my_dico[L[i]] = L[i + 3]
        if 'ADRESSE' in L[i]:
            my_dico[L[i]] = L[i + 2] + " " + L[i + 6] + " " + L[i + 9]
        if 'N DU DOCUMENT' in L[i]:
            my_dico[L[i]] = L[i + 7]
        if 'DATE DEXPIR' in L[i]:
            my_dico[L[i]] = L[i + 7] + " " + L[i + 8]
        if 'DATE DE DÉLIVRANCE' in L[i]:
            my_dico[L[i]] = L[i + 4] + " " + L[i + 5]

    return jsonify(my_dico)
    #with open("data.json", "a") as file:
        #json.dump(my_dico, file)
    #file.close()




#if __name__=='main':
    #pass

if __name__ == '__main__':
    app.run(port=9000,debug=True)
