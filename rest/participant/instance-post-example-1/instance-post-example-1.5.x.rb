require 'rubygems' # not necessary with ruby 1.9 but included for completeness
require 'twilio-ruby'

# put your own credentials here
account_sid = 'ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX'
auth_token = 'your_auth_token'

# set up a client to talk to the Twilio REST API
@client = Twilio::REST::Client.new(account_sid, auth_token)

# Get a participant from a specific conference call by sid
@participant = @client.account
                      .conferences('CFbbe4632a3c49700934481addd5ce1659')
                      .participants('CA386025c9bf5d6052a1d1ea42b4d16662')
                      .fetch

# Mute the selected participant
@participant.update(muted: 'True')

# Print the mute status
puts @participant.muted