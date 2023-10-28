// =============
// =   Login   =
// =============

export const BOT_STARTED_LOG = (botName) => {
    return `Bot started as "${botName}"`;
}

export const USER_STARTED_THE_BOT = (userNickname) => {
    return `User with the nickname "${userNickname}" has started the bot`;
}

export const USER_LOGIN_IS_ATTEMPTED = (userNickname, userTelegramId) => {
    return `User with the nickname "${userNickname}" and telegram ID "${userTelegramId}" attempt to login`;
}

export const USER_FIRST_TIME_LOGIN_IS_SUCCESSFUL = (userNickname, userTelegramId, userId) => {
    return `User with the nickname "${userNickname}" and telegram ID "${userTelegramId}" successfully logged in for the first time with the user ID "${userId}"`;
}

export const USER_LOGIN_IS_SUCCESSFUL = (userNickname, userTelegramId, userId) => {
    return `User with the nickname "${userNickname}" and telegram ID "${userTelegramId}" successfully logged in with the user ID "${userId}"`;
}

export const SET_USER_REGION_IS_ATTEMPTED = (userId, regionId) => {
    return `Attempting to set region with ID "${regionId}" for user with id "${userId}"`;
}

export const USER_REGION_IS_SET = (userId, regionId) => {
    return `Region with ID "${regionId}" is successfully set for user with id "${userId}"`;

}