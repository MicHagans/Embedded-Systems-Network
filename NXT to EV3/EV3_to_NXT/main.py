#!/usr/bin/env pybricks-micropython
from pybricks.hubs import EV3Brick
from pybricks.ev3devices import (Motor, TouchSensor, ColorSensor,
                                 InfraredSensor, UltrasonicSensor, GyroSensor)
from pybricks.parameters import Port, Stop, Direction, Button, Color
from pybricks.tools import wait, StopWatch, DataLog
from pybricks.robotics import DriveBase
from pybricks.media.ev3dev import SoundFile, ImageFile
from pybricks.messaging import BluetoothMailboxClient, NumericMailbox, TextMailbox


# client = BluetoothMailboxClient()
# # This will list everything the 'client' knows how to do or access
# print("I found these attributes:")
# print(dir(client))
# 1. Setup the address

NXT_ADDR = '00:16:53:19:24:38'
client = BluetoothMailboxClient()
mbox = TextMailbox('a', client) # Keep the name 'a' to keep the header tiny

print("Connecting...")
try:
    client.connect(NXT_ADDR)
    print("Connected!")
    mbox.send("FORWARD")
    print("Sent!")

except Exception as e:
    print("Failed:", e)



# inbox = Mailbox('reply', client)

# # In your main loop:
# if inbox.wait(): # Waits for a new message
#     print("NXT says:", inbox.read())
