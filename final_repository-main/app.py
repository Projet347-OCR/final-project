import PySimpleGUI as sg



frame_layout = [
                  [sg.T('Text inside of a frame')],
                  [sg.CB('Check 1'), sg.CB('Check 2')],
               ]
layout = [
          [sg.Frame('My Frame Title', frame_layout, font='Any 12', title_color='blue')],
          [sg.Submit(), sg.Cancel()],
          [sg.Image(r'home.png')]
         ]

# Create the Window
window = sg.Window('My Application', layout, font=("Helvetica", 12))
window.set_icon('logo.ico')

while True:
    event, values = window.read()
    if event == sg.WIN_CLOSED or event == 'Cancel': # if user closes window or clicks cancel
        break



















# sg.theme('DarkAmber')   # Add a touch of color
# # All the stuff inside your window.
# layout = [  [sg.Text('Some text on Row 1', font='Courier 12', text_color='blue', background_color='green')],
#             [sg.Text('Enter something on Row 2'), sg.InputText()],
#             [sg.Button('Ok'), sg.Button('Cancel')],
#             ]
# # Create the Window
# window = sg.Window('My Application', layout, font=("Helvetica", 12))
# window.set_icon('logo.ico')
# # Event Loop to process "events" and get the "values" of the inputs
# while True:
#     event, values = window.read()
#     if event == sg.WIN_CLOSED or event == 'Cancel': # if user closes window or clicks cancel
#         break
#     print('You entered ', values[0])
#
