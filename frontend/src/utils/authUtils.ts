export const getCurrentUser = () => {
    const userData = localStorage.getItem('username')
    if (!userData) return null

    try {
        return JSON.parse(userData)
    } catch (error) {
        console.error('Error parsing user data from localStorage:', error)
        return null
    }
}

export const getCurrentUserId = (): number | null => {
    const user = getCurrentUser()
    return user?.id ?? null
}

export const isUserLoggedIn = (): boolean => {
    return getCurrentUserId() !== null
}
