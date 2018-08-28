package com.InterviewProblems;

import java.io.*;
/**
 * Created by anuj.jain02 on 6/3/17.
 */



public class TV_Remote {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        /*BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String startAndEndChannel = buffer.readLine();
        String listOfChannels = buffer.readLine();*/
        String startAndEndChannel = "0,100";
        String listOfChannels = "85,90,85,90";
        int minimumClicks = getMinimumClicks(startAndEndChannel,listOfChannels);
        System.out.println(minimumClicks);
    }
    public static int getMinimumClicks(String startAndEndChannel,String listOfChannels)
    {

        String[] startAndEndChannels = startAndEndChannel.split(",");
        int start = Integer.parseInt(startAndEndChannels[0]);
        int end = Integer.parseInt(startAndEndChannels[1]);
        int minClicks = 0, alternateChannel = start, lastChannel = start, punchClick, rightClick, leftClick, altRightClick, altLeftClick;
        String[] channels = listOfChannels.split(",");
        for(int i = 0 ; i < channels.length ; i++){
            punchClick = channels[i].length();
            int currentChannel = Integer.parseInt(channels[i]);
            if(currentChannel < start || currentChannel > end)
                return 0;
            if(currentChannel > lastChannel){
                rightClick = currentChannel - lastChannel;
                leftClick = (lastChannel - start) + (end - currentChannel) + 1;
            }
            else{
                rightClick = (end - lastChannel) + (currentChannel - start) + 1;
                leftClick = lastChannel - currentChannel;
            }
            if(currentChannel > alternateChannel){
                altRightClick = currentChannel - alternateChannel + 1;
                altLeftClick = (alternateChannel - start) + (end - currentChannel) + 2;
            }
            else{
                altRightClick = (end - alternateChannel) + (currentChannel - start) + 2;
                altLeftClick = alternateChannel - currentChannel + 1;
            }

            System.out.println("For: "+currentChannel+ " punchClick: "+punchClick+" rightClick: "+rightClick+" leftClick: "+
                              leftClick+" altRightClick: "+altRightClick+" altLeftClick: "+altLeftClick);
            if(punchClick < rightClick){
                if(punchClick < leftClick){
                    if(punchClick < altRightClick){
                        if(punchClick < altLeftClick){
                            minClicks+= punchClick;
                            alternateChannel = lastChannel;
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                    else{
                        if(altRightClick < altLeftClick){
                            minClicks+= altRightClick;
                            if(altRightClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel < lastChannel){
                                alternateChannel = currentChannel + 1;
                            }
                            else{
                                alternateChannel =  currentChannel - 1;
                            }
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                }
                else{
                    if(leftClick < altRightClick){
                        if(leftClick < altLeftClick){
                            minClicks+= leftClick;
                            if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                    else{
                        if(altRightClick < altLeftClick){
                            minClicks+= altRightClick;
                            if(altRightClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel < lastChannel){
                                alternateChannel = currentChannel + 1;
                            }
                            else{
                                alternateChannel =  currentChannel - 1;
                            }
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                }
            }
            else{
                if(rightClick < leftClick){
                    if(rightClick < altRightClick){
                        if(rightClick < altLeftClick){
                            minClicks+= rightClick;
                            if(currentChannel < lastChannel){
                                alternateChannel = currentChannel + 1;
                            }
                            else{
                                alternateChannel =  currentChannel - 1;
                            }
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                    else{
                        if(altRightClick < altLeftClick){
                            minClicks+= altRightClick;
                            if(altRightClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel < lastChannel){
                                alternateChannel = currentChannel + 1;
                            }
                            else{
                                alternateChannel =  currentChannel - 1;
                            }
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                }
                else{
                    if(leftClick < altRightClick){
                        if(leftClick < altLeftClick){
                            minClicks+= leftClick;
                            if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                    else{
                        if(altRightClick < altLeftClick){
                            minClicks+= altRightClick;
                            if(altRightClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel < lastChannel){
                                alternateChannel = currentChannel + 1;
                            }
                            else{
                                alternateChannel =  currentChannel - 1;
                            }
                            lastChannel = currentChannel;
                        }
                        else{
                            minClicks+= altLeftClick;
                            if(altLeftClick == 1)
                                alternateChannel = lastChannel;
                            else if(currentChannel > lastChannel){
                                alternateChannel = currentChannel - 1;
                            }
                            else{
                                alternateChannel =  currentChannel + 1;
                            }
                            lastChannel = currentChannel;
                        }
                    }
                }
            }
        }

        return minClicks;
    }
}