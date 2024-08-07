import tkinter as tk
from time import sleep
import threading

class BouncingWindow(tk.Frame):
    def __init__(self, parent):
        super().__init__(parent)

        self.background = "white"
        self.text = tk.Label(self, text="Está se\nmovimentando.", font="Arial 30", bg="white")
        self.text.pack()
        
        self.x = 1  # Velocidade de deslocamento na horizontal
        self.y = 1  # Velocidade de deslocamento para baixo

        thread_one = threading.Thread(target=self.switch_background)
        thread_two = threading.Thread(target=self.move_window)
        thread_one.start()        
        thread_two.start()

    def switch_background(self):        
        while True:
            if self.background == 'white':
                self.background = 'black'
                self.text['fg'] = 'white'
                self.text['bg'] = self.background
            else:
                self.background = 'white'
                self.text['fg'] = 'black'
                self.text['bg'] = self.background
            self.master.configure(bg=self.background)
            sleep(3)
            

    def move_window(self):
        x_pos = self.master.winfo_x() # Captura a coordenada da window
        y_pos = self.master.winfo_y() # Captura a coordenada da window
        x_pos += self.x # Soma que faz eles se movimentarem posx=500 + x=1 = 501
        y_pos += self.y # Soma que faz eles se movimentarem posy=500 + y=1 = 501

        if x_pos <= 0 or x_pos + width >= width_screen:
            self.x = -self.x                                # Inversão das coordenadas 
        if y_pos <= 0 or y_pos + height >= height_screen:
            self.y = -self.y                                # Inversão das coordenadas 

        self.master.geometry(f"+{x_pos}+{y_pos}")
        self.after(2, self.move_window)

root = tk.Tk()
root.title("Bouncing Window")
root.configure(bg='white')

width = 300
height = 200
width_screen = root.winfo_screenwidth()
height_screen = root.winfo_screenheight()
root.geometry(f"{width}x{height}")

boucing = BouncingWindow(root)
boucing.place(relx=0.5, rely=0.45, anchor=tk.CENTER)

root.mainloop()